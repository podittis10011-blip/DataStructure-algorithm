package DataStructure.JavaCollection;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ConcurrentHashMap 的可执行核心路径镜像（JDK 17）。
 *
 * <p>对照源（OpenJDK 17u）：
 * {@code ConcurrentHashMap.java} 的 get 893-914、putVal 964-1026、
 * initTable 2206-2226、addCount 2238 起、transfer 2335 起、spread 529-532、
 * tabAt/casTabAt/setTabAt 573-587（在线源码行号）。
 *
 * <p>此镜像精确保留普通桶的核心并发分工：空桶 CAS；非空链表桶 synchronized(f)；
 * Node.value/next 与 table 为 volatile 读取路径。为了使代码能在普通教学工程中清晰运行，
 * 用 VarHandle 替代 JDK 源码中的 Unsafe，且不实现协作 resize、ForwardingNode、TreeBin、
 * CounterCell 和批量操作。因此它是源码对照物，不是生产级并发 Map。
 */
public final class Jdk17ConcurrentHashMapCoreMirror<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final int HASH_BITS = 0x7fffffff;

    private static final VarHandle NODE_ARRAY = MethodHandles.arrayElementVarHandle(Node[].class);

    /** JDK 源码是 volatile Node[] table；此处保留相同发布语义。 */
    private volatile Node<K, V>[] table;
    /** 对照 initTable 的 sizeCtl：负数表示某线程正在初始化。 */
    private final AtomicInteger sizeCtl = new AtomicInteger();
    /** 教学替代：JDK 使用 baseCount + CounterCell 以降低高竞争计数开销。 */
    private final AtomicInteger mappingCount = new AtomicInteger();

    /** Source ConcurrentHashMap.java:529-532. */
    static int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    /** Source ConcurrentHashMap.java:573-587; Unsafe 改为标准 VarHandle API。 */
    @SuppressWarnings("unchecked")
    private static <K, V> Node<K, V> tabAt(Node<K, V>[] tab, int index) {
        return (Node<K, V>) NODE_ARRAY.getAcquire(tab, index);
    }

    private static <K, V> boolean casTabAt(Node<K, V>[] tab, int index,
                                            Node<K, V> expected, Node<K, V> update) {
        return NODE_ARRAY.compareAndSet(tab, index, expected, update);
    }

    /** Source ConcurrentHashMap.java:2206-2226; AtomicInteger CAS 代替 Unsafe CAS。 */
    @SuppressWarnings("unchecked")
    private Node<K, V>[] initTable() {
        Node<K, V>[] tab;
        int sc;
        while ((tab = table) == null || tab.length == 0) {
            if ((sc = sizeCtl.get()) < 0) {
                Thread.yield();
            } else if (sizeCtl.compareAndSet(sc, -1)) {
                try {
                    if ((tab = table) == null || tab.length == 0) {
                        int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
                        tab = (Node<K, V>[]) new Node[n];
                        table = tab;
                        sc = n - (n >>> 2); // JDK 的 0.75 容量阈值表达式
                    }
                } finally {
                    sizeCtl.set(sc);
                }
                break;
            }
        }
        return tab;
    }

    /** Source ConcurrentHashMap.java:893-914; 特殊节点（MOVED/TREEBIN）分支未纳入此镜像。 */
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException("ConcurrentHashMap does not permit null keys");
        }
        Node<K, V>[] tab;
        Node<K, V> e;
        int n;
        int h = spread(key.hashCode());
        if ((tab = table) != null && (n = tab.length) > 0
                && (e = tabAt(tab, (n - 1) & h)) != null) {
            return e.find(h, key);
        }
        return null;
    }

    public V put(K key, V value) {
        return putVal(key, value, false);
    }

    public V putIfAbsent(K key, V value) {
        return putVal(key, value, true);
    }

    /**
     * Source ConcurrentHashMap.java:964-1026，保留空桶 CAS 与普通链表桶 synchronized(f)。
     * 不出现 ForwardingNode/TreeBin 的原因见类注释。
     */
    private V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) {
            throw new NullPointerException("ConcurrentHashMap does not permit null keys or values");
        }
        int hash = spread(key.hashCode());
        for (Node<K, V>[] tab = table; ; ) {
            Node<K, V> first;
            int n;
            int index;
            if (tab == null || (n = tab.length) == 0) {
                tab = initTable();
            } else if ((first = tabAt(tab, index = (n - 1) & hash)) == null) {
                if (casTabAt(tab, index, null, new Node<>(hash, key, value))) {
                    mappingCount.incrementAndGet();
                    return null;
                }
            } else {
                V oldValue = null;
                boolean inserted = false;
                synchronized (first) {
                    if (tabAt(tab, index) == first) {
                        Node<K, V> node = first;
                        for (;;) {
                            K nodeKey;
                            if (node.hash == hash
                                    && ((nodeKey = node.key) == key
                                    || (nodeKey != null && key.equals(nodeKey)))) {
                                oldValue = node.val;
                                if (!onlyIfAbsent) {
                                    node.val = value;
                                }
                                break;
                            }
                            Node<K, V> next = node.next;
                            if (next == null) {
                                node.next = new Node<>(hash, key, value);
                                inserted = true;
                                break;
                            }
                            node = next;
                        }
                    }
                }
                if (inserted) {
                    mappingCount.incrementAndGet();
                    return null;
                }
                if (oldValue != null) {
                    return oldValue;
                }
                // 当前桶首节点已被替换时，重试；JDK 在遇到 MOVED 时会 helpTransfer。
            }
        }
    }

    public int size() {
        return mappingCount.get();
    }

    /** Source ConcurrentHashMap.java:3334 起；value 与 next 的 volatile 是读路径关键。 */
    static final class Node<K, V> {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K, V> next;

        Node(int hash, K key, V val) {
            this.hash = hash;
            this.key = key;
            this.val = val;
        }

        V find(int h, Object k) {
            Node<K, V> e = this;
            do {
                K ek;
                if (e.hash == h && ((ek = e.key) == k || (ek != null && k.equals(ek)))) {
                    return e.val;
                }
            } while ((e = e.next) != null);
            return null;
        }
    }
}

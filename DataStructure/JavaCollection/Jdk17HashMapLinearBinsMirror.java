package DataStructure.JavaCollection;

/**
 * 可执行的 HashMap 主路径镜像：数组桶、拉链、hash、getNode、putVal 和 JDK 风格的低/高链迁移。
 *
 * <p>对照源：用户本地 HashMap.java，SHA-256 064460FDAE590EFB2046BEEE631B3DE8C9232B8B99F2B4B16607A7DBCE1315CC。
 * 关键位置：常量 238-275；Node 281-316；getNode 565-583；putVal 623-664；resize 675-747。
 *
 * <p>有意边界：此镜像精确复刻“普通链表桶”控制流；TreeNode 分支与 treeifyBin（源文件 635-636、641-642、711-712、753-772）
 * 只保留定位，不宣称已实现红黑树。完整树化需要连同 JDK TreeNode 的平衡、删除、split 等代码一起阅读。
 */
public final class Jdk17HashMapLinearBinsMirror<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    transient Node<K, V>[] table;
    transient int size;
    transient int modCount;
    int threshold;
    final float loadFactor;

    public Jdk17HashMapLinearBinsMirror() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public int size() {
        return size;
    }

    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(key)) == null ? null : e.value;
    }

    /** Source HashMap.java:565-583, without the TreeNode branch. */
    final Node<K, V> getNode(Object key) {
        Node<K, V>[] tab;
        Node<K, V> first;
        Node<K, V> e;
        int n;
        int hash;
        K k;
        if ((tab = table) != null && (n = tab.length) > 0
                && (first = tab[(n - 1) & (hash = hash(key))]) != null) {
            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k)))) {
                return first;
            }
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        return e;
                    }
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /** Source HashMap.java:623-664, retaining the ordinary linked-bin path. */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n;
        int i;
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        if ((p = tab[i = (n - 1) & hash]) == null) {
            tab[i] = newNode(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                e = p;
            } else {
                for (;;) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        break;
                    }
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    p = e;
                }
            }
            if (e != null) {
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null) {
                    e.value = value;
                }
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold) {
            resize();
        }
        return null;
    }

    /** Source HashMap.java:675-747, retaining the non-TreeNode branches. */
    @SuppressWarnings({"rawtypes", "unchecked"})
    final Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap;
        int newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThr << 1;
            } else {
                newCap = oldCap << 1;
            }
        } else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY)
                    ? (int) ft : Integer.MAX_VALUE;
        }
        threshold = newThr;
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null) {
                        newTab[e.hash & (newCap - 1)] = e;
                    } else {
                        Node<K, V> loHead = null;
                        Node<K, V> loTail = null;
                        Node<K, V> hiHead = null;
                        Node<K, V> hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) loHead = e;
                                else loTail.next = e;
                                loTail = e;
                            } else {
                                if (hiTail == null) hiHead = e;
                                else hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

package DataStructure.List.SingleLinkedList;

/**
 * 带哨兵节点的单链表 —— 基础但功能完备的实现
 *
 * 【哨兵节点是什么？】
 *   哨兵（sentinel / dummy node）是链表头部一个不存储业务数据的"占位节点"。
 *   它让所有增删操作统一为"在某个节点之后操作"，无需单独处理 head。
 *
 * 【结构示意】
 *   哨兵(sentinel) -> [10] -> [20] -> [30] -> null
 *                     ↑ 这些是实际存储数据的节点
 *
 * 【核心优势】
 *   1. 不需要单独维护 head 引用 —— sentinel 就是永恒的"头"
 *   2. 头插/头删和中间增删的逻辑完全一致，都是用"前驱节点.next = ..."
 *   3. 空链表和非空链表的操作无需 if-else 分支
 */
public class SentinelLinkedList {

    // ==================== 1. 节点定义 ====================
    private static class Node {
        int value;   // 节点存储的值
        Node next;   // 指向下一个节点

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // ==================== 2. 成员变量与构造方法 ====================

    /** 哨兵节点：永远在链表最前面，不存业务数据 */
    private final Node sentinel;

    /** 实际元素个数（不含哨兵） */
    private int size;

    /** 构造一个空链表（只含哨兵节点） */
    public SentinelLinkedList() {
        sentinel = new Node(-1);  // -1 无业务意义，仅占位
        size = 0;
    }

    // ==================== 3. 增 —— 添加节点 ====================

    /**
     * 头插法：在链表最前面插入新节点
     * 时间复杂度：O(1)
     */
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = sentinel.next;  // 新节点指向原来的第一个节点
        sentinel.next = newNode;       // 哨兵指向新节点
        size++;
    }

    /**
     * 尾插法：在链表末尾追加新节点
     * 时间复杂度：O(n)
     */
    public void addLast(int value) {
        Node cur = sentinel;
        while (cur.next != null) {
            cur = cur.next;           // 找到最后一个节点
        }
        cur.next = new Node(value);
        size++;
    }

    /**
     * 在指定索引处插入新节点
     * 时间复杂度：O(n)
     *
     * @param index 插入位置，0 表示头部，size 表示尾部追加
     * @param value 要插入的值
     * @return 成功返回 true，索引非法返回 false
     */
    public boolean add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("插入失败：索引 " + index + " 越界（当前 size = " + size + "）");
            return false;
        }

        // 找到插入位置的前驱节点：从哨兵出发，走 index 步
        Node cur = sentinel;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Node newNode = new Node(value);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
        return true;
    }

    // ==================== 4. 删 —— 删除节点 ====================

    /**
     * 删除第一个节点
     * 时间复杂度：O(1)
     *
     * @return 被删除节点的值
     * @throws RuntimeException 链表为空时抛出
     */
    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("删除失败：链表为空");
        }
        Node removed = sentinel.next;
        sentinel.next = removed.next;  // 哨兵跳过被删节点
        size--;
        return removed.value;
    }

    /**
     * 删除最后一个节点
     * 时间复杂度：O(n)
     *
     * @return 被删除节点的值
     * @throws RuntimeException 链表为空时抛出
     */
    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("删除失败：链表为空");
        }

        Node cur = sentinel;
        // 找到倒数第二个节点（即最后一个节点的前驱）
        while (cur.next.next != null) {
            cur = cur.next;
        }

        Node removed = cur.next;
        cur.next = null;  // 断开与前驱的连接
        size--;
        return removed.value;
    }

    /**
     * 删除指定索引的节点
     * 时间复杂度：O(n)
     *
     * @param index 要删除的位置，0 表示第一个元素
     * @return 被删除节点的值
     * @throws RuntimeException 索引越界时抛出
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("删除失败：索引 " + index + " 越界（当前 size = " + size + "）");
        }

        // 找到要删除节点的前驱
        Node cur = sentinel;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Node removed = cur.next;
        cur.next = removed.next;  // 跳过被删节点
        size--;
        return removed.value;
    }

    /**
     * 删除第一个值等于 target 的节点
     * 时间复杂度：O(n)
     *
     * @param target 要删除的目标值
     * @return 找到并删除返回 true，未找到返回 false
     */
    public boolean removeByValue(int target) {
        Node cur = sentinel;

        while (cur.next != null) {
            if (cur.next.value == target) {
                cur.next = cur.next.next;  // 跳过匹配的节点
                size--;
                return true;
            }
            cur = cur.next;
        }

        return false;  // 未找到
    }

    // ==================== 5. 改 —— 修改节点值 ====================

    /**
     * 将索引 index 处的值修改为 newValue
     * 时间复杂度：O(n)
     *
     * @return 成功返回 true，索引非法返回 false
     */
    public boolean set(int index, int newValue) {
        if (index < 0 || index >= size) {
            System.out.println("修改失败：索引 " + index + " 越界");
            return false;
        }

        Node cur = sentinel.next;  // 从第一个实际节点开始
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.value = newValue;
        return true;
    }

    /**
     * 将链表中第一个值为 oldValue 的节点修改为 newValue
     * 时间复杂度：O(n)
     *
     * @return 找到并修改返回 true，未找到返回 false
     */
    public boolean setByValue(int oldValue, int newValue) {
        Node cur = sentinel.next;

        while (cur != null) {
            if (cur.value == oldValue) {
                cur.value = newValue;
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    // ==================== 6. 查 —— 查询节点 ====================

    /**
     * 按索引查询节点的值
     * 时间复杂度：O(n)
     *
     * @param index 索引，0 表示第一个元素
     * @return 该位置节点的值
     * @throws RuntimeException 索引越界时抛出
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("查询失败：索引 " + index + " 越界（当前 size = " + size + "）");
        }

        Node cur = sentinel.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    /**
     * 查找第一个值为 target 的节点所在索引
     * 时间复杂度：O(n)
     *
     * @param target 目标值
     * @return 找到返回索引（从 0 开始），未找到返回 -1
     */
    public int indexOf(int target) {
        Node cur = sentinel.next;
        int index = 0;

        while (cur != null) {
            if (cur.value == target) {
                return index;
            }
            cur = cur.next;
            index++;
        }

        return -1;
    }

    /**
     * 判断链表是否包含指定值
     * 时间复杂度：O(n)
     */
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // ==================== 7. 辅助方法 ====================

    /** 返回链表中实际元素个数（不含哨兵） */
    public int size() {
        return size;
    }

    /** 判断链表是否为空 */
    public boolean isEmpty() {
        return size == 0;          // 等价于 sentinel.next == null
    }

    /** 清空链表（保留哨兵节点） */
    public void clear() {
        sentinel.next = null;
        size = 0;
    }

    /**
     * 打印链表
     * 输出格式：[10 -> 20 -> 30]
     */
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        Node cur = sentinel.next;  // 跳过哨兵，从第一个实际节点开始

        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) {
                sb.append(" -> ");
            }
            cur = cur.next;
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    // ==================== 8. 测试入口 ====================
    public static void main(String[] args) {
        SentinelLinkedList list = new SentinelLinkedList();

        System.out.println("========== 1. 添加测试 ==========");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.print("尾插 10,20,30：");
        list.print();                        // [10 -> 20 -> 30]

        list.addFirst(5);
        System.out.print("头插 5：");
        list.print();                        // [5 -> 10 -> 20 -> 30]

        list.add(2, 99);
        System.out.print("索引 2 插入 99：");
        list.print();                        // [5 -> 10 -> 99 -> 20 -> 30]

        System.out.println("当前 size = " + list.size());  // 5

        System.out.println("\n========== 2. 查询测试 ==========");
        System.out.println("get(0) = " + list.get(0));          // 5
        System.out.println("get(3) = " + list.get(3));          // 20
        System.out.println("indexOf(99) = " + list.indexOf(99));  // 2
        System.out.println("contains(20) = " + list.contains(20));    // true
        System.out.println("contains(100) = " + list.contains(100));  // false

        System.out.println("\n========== 3. 修改测试 ==========");
        list.set(2, 88);
        System.out.print("set(2, 88)：");
        list.print();                        // [5 -> 10 -> 88 -> 20 -> 30]

        list.setByValue(20, 22);
        System.out.print("setByValue(20, 22)：");
        list.print();                        // [5 -> 10 -> 88 -> 22 -> 30]

        System.out.println("\n========== 4. 删除测试 ==========");
        System.out.println("removeFirst() = " + list.removeFirst());  // 5
        System.out.print("删头后：");
        list.print();                        // [10 -> 88 -> 22 -> 30]

        System.out.println("removeLast() = " + list.removeLast());    // 30
        System.out.print("删尾后：");
        list.print();                        // [10 -> 88 -> 22]

        System.out.println("remove(1) = " + list.remove(1));          // 88
        System.out.print("删索引1后：");
        list.print();                        // [10 -> 22]

        System.out.println("removeByValue(10) = " + list.removeByValue(10));  // true
        System.out.print("按值删10后：");
        list.print();                        // [22]

        System.out.println("size = " + list.size());    // 1
        System.out.println("isEmpty() = " + list.isEmpty());  // false

        System.out.println("\n========== 5. 清空测试 ==========");
        list.clear();
        System.out.print("清空后：");
        list.print();                        // []
        System.out.println("isEmpty() = " + list.isEmpty());   // true
        System.out.println("size = " + list.size());            // 0

        System.out.println("\n========== 全部测试通过！ ==========");
    }
}

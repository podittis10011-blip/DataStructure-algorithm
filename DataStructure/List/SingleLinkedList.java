package DataStructure.List;

public class SingleLinkedList {
    
    //初始化哨兵节点
    //next指向
    public void init(){

    }

    //增加节点

    //删除节点

    //修改节点值

    //查询节点值

    public static void main(String[] args) {

    }
}

/*
 * ============================================================
 *  带哨兵节点的单链表 — 完整实现（供学习参考）
 * ============================================================
 *
 *  哨兵节点（sentinel/dummy node）的作用：
 *  - 哨兵是链表头部一个不存储业务数据的"占位节点"
 *  - 它让所有增删操作变成统一的"在某个节点之后操作"，无需特殊处理 head
 *  - 没有哨兵时：头插/删头需要单独处理 head 引用
 *  - 有了哨兵后：所有操作都通过 sentinel.next 或遍历找到目标的前驱来完成
 *
 * ============================================================
 *  以下是完整的带哨兵单链表实现代码（可将注释去掉后运行）
 * ============================================================

package DataStructure.List;

public class SingleLinkedListWithSentinel {

    // ==================== 1. 节点定义 ====================
    // 内部类，只有链表内部会用到，设为 private
    private static class Node {
        int val;        // 节点存储的值
        Node next;      // 指向下一个节点的引用

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ==================== 2. 哨兵节点 + 初始化 ====================
    private Node sentinel;  // 哨兵节点，永远指向链表头部（不存业务数据）
    private int size;       // 链表中实际元素的个数（不算哨兵）

    // 构造方法：创建哨兵节点，初始时 next 指向 null（空链表）
    public SingleLinkedListWithSentinel() {
        sentinel = new Node(-1);  // -1 是哨兵的值，无业务意义，可以取任意值
        size = 0;
    }

    // ==================== 3. 增 — 添加节点 ====================

    // 3.1 头插法：在链表最前面插入（O(1)）
    // 哨兵的优势：头插和中间插入逻辑完全一致 —— 都是在某个节点之后插入
    public void addFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = sentinel.next;   // 新节点指向原来的第一个节点
        sentinel.next = newNode;        // 哨兵指向新节点
        size++;
    }

    // 3.2 尾插法：在链表末尾插入（O(n)）
    public void addLast(int val) {
        Node cur = sentinel;
        // 找到最后一个节点
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val);
        size++;
    }

    // 3.3 在指定索引处插入（O(n)）
    // index 从 0 开始，0 表示插在第一个位置
    public boolean add(int index, int val) {
        if (index < 0 || index > size) {
            System.out.println("插入失败：索引 " + index + " 越界，当前 size = " + size);
            return false;
        }
        // 找到 index 位置的前驱节点
        // 移动 index 步：cur 从哨兵出发，走 0 步→哨兵（插在头部），走 1 步→第 1 个节点（插在第 2 位）
        Node cur = sentinel;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node newNode = new Node(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
        return true;
    }

    // ==================== 4. 删 — 删除节点 ====================

    // 4.1 删除第一个节点（O(1)）
    public int removeFirst() {
        if (sentinel.next == null) {
            throw new RuntimeException("链表为空，无法删除");
        }
        Node removed = sentinel.next;
        sentinel.next = removed.next;   // 跳过被删节点
        size--;
        return removed.val;
    }

    // 4.2 删除最后一个节点（O(n)）
    public int removeLast() {
        if (sentinel.next == null) {
            throw new RuntimeException("链表为空，无法删除");
        }
        Node cur = sentinel;
        // 找到倒数第二个节点（最后一个的前驱）
        while (cur.next.next != null) {
            cur = cur.next;
        }
        Node removed = cur.next;
        cur.next = null;
        size--;
        return removed.val;
    }

    // 4.3 删除指定索引的节点（O(n)）
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("删除失败：索引 " + index + " 越界，当前 size = " + size);
        }
        // 找到 index 位置的前驱
        Node cur = sentinel;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node removed = cur.next;
        cur.next = removed.next;
        size--;
        return removed.val;
    }

    // 4.4 删除第一个值为 val 的节点（O(n)）
    public boolean removeByValue(int val) {
        Node cur = sentinel;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;   // 跳过匹配的节点
                size--;
                return true;                // 只删第一个匹配的
            }
            cur = cur.next;
        }
        return false;   // 没找到
    }

    // ==================== 5. 改 — 修改节点值 ====================

    // 5.1 按索引修改（O(n)）
    public boolean set(int index, int val) {
        if (index < 0 || index >= size) {
            System.out.println("修改失败：索引 " + index + " 越界");
            return false;
        }
        Node cur = sentinel.next;   // 从第一个实际节点开始
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.val = val;
        return true;
    }

    // 5.2 将第一个等于 oldVal 的节点改为 newVal（O(n)）
    public boolean setByValue(int oldVal, int newVal) {
        Node cur = sentinel.next;
        while (cur != null) {
            if (cur.val == oldVal) {
                cur.val = newVal;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // ==================== 6. 查 — 查询节点值 ====================

    // 6.1 按索引查询（O(n)）
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("查询失败：索引 " + index + " 越界");
        }
        Node cur = sentinel.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // 6.2 查找第一个值为 val 的索引（O(n)），未找到返回 -1
    public int indexOf(int val) {
        Node cur = sentinel.next;
        int index = 0;
        while (cur != null) {
            if (cur.val == val) {
                return index;
            }
            cur = cur.next;
            index++;
        }
        return -1;
    }

    // 6.3 判断链表是否包含某个值（O(n)）
    public boolean contains(int val) {
        return indexOf(val) != -1;
    }

    // ==================== 7. 辅助方法 ====================

    // 获取链表大小
    public int size() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;          // 等价于 sentinel.next == null
    }

    // 打印链表
    public void print() {
        System.out.print("[");
        Node cur = sentinel.next;  // 跳过哨兵，从第一个实际节点开始
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }

    // ==================== 8. 测试 main ====================
    public static void main(String[] args) {
        SingleLinkedListWithSentinel list = new SingleLinkedListWithSentinel();

        // 测试增
        System.out.println("=== 测试添加 ===");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.print();   // [10 -> 20 -> 30]

        list.addFirst(5);
        list.print();   // [5 -> 10 -> 20 -> 30]

        list.add(2, 99);    // 在索引2插入99
        list.print();       // [5 -> 10 -> 99 -> 20 -> 30]

        // 测试查
        System.out.println("\n=== 测试查询 ===");
        System.out.println("索引0的值: " + list.get(0));          // 5
        System.out.println("值99的索引: " + list.indexOf(99));    // 2
        System.out.println("是否包含20: " + list.contains(20));   // true
        System.out.println("是否包含100: " + list.contains(100)); // false
        System.out.println("size: " + list.size());               // 5

        // 测试改
        System.out.println("\n=== 测试修改 ===");
        list.set(2, 88);            // 索引2改为88
        list.setByValue(20, 22);   // 值20改为22
        list.print();               // [5 -> 10 -> 88 -> 22 -> 30]

        // 测试删
        System.out.println("\n=== 测试删除 ===");
        list.removeFirst();
        list.print();   // [10 -> 88 -> 22 -> 30]

        list.removeLast();
        list.print();   // [10 -> 88 -> 22]

        list.remove(1);
        list.print();   // [10 -> 22]

        list.removeByValue(10);
        list.print();   // [22]

        System.out.println("size: " + list.size());   // 1
        System.out.println("是否为空: " + list.isEmpty()); // false
    }
}

 * ============================================================
 *  总结：哨兵节点的核心优势
 * ============================================================
 *  1. 不需要单独维护 head 引用 → sentinel 就是永恒的"头"
 *  2. 增删操作统一为"找到前驱 → 修改前驱的 next"
 *  3. 空链表和非空链表的操作逻辑完全一致，无需 if 分支判断
 *  4. 代码更简洁，边界条件更容易处理
 *
 *  画个图帮助理解：
 *
 *  哨兵节点 → [10] → [20] → [30] → null
 *     ↑                              ↑
 *  sentinel                   cur.next == null 表示结尾
 *
 *  在 10 和 20 之间插入 99：
 *  1. 找到前驱(10的位置)，即索引0的节点
 *  2. newNode.next = 前驱.next
 *  3. 前驱.next = newNode
 *
 *  哨兵节点 → [10] → [99] → [20] → [30] → null
 *
 * ============================================================
 */

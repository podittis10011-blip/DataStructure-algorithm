public class removeElements {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }
}

/*
 * ============================================================
 *  LeetCode 203. 移除链表元素 — 哨兵节点解法
 * ============================================================
 *
 *  你的原思路：
 *      node = head
 *      while node ≠ null:
 *          if node.val == val:
 *              node.next = node.next.next   ← 问题：删的是 node.next，不是 node 本身
 *          node = node.next
 *
 *  两个问题：
 *      1. 判断 node.val 却删 node.next → 逻辑错位
 *      2. head 本身要删时，无法处理（没有前驱）
 *
 *  正确思路：
 *      - 加一个哨兵节点 dummy，dummy.next = head
 *      - 始终判断 cur.next.val（而不是 cur.val）
 *      - 这样 cur 永远是"前驱"，删除操作直接 cur.next = cur.next.next
 *      - 返回 dummy.next 就是新头节点（即使原 head 被删了也正确）
 * ============================================================


// 解法代码（去注释后可直接运行）
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 1. 创建哨兵节点，指向原头节点
        ListNode dummy = new ListNode(-1, head);
        //          等价于: dummy.next = head;

        // 2. cur 从哨兵出发
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                // 命中：跳过 cur.next 这个节点
                cur.next = cur.next.next;
                // 关键：删除后 cur 不动！因为新的 cur.next 还没检查过
            } else {
                // 未命中：cur 后移，继续检查下一个
                cur = cur.next;
            }
        }

        // 3. 哨兵.next 就是新链表的头节点
        return dummy.next;
    }
}

// 图解：删除链表中所有值为 6 的节点
//
// 初始：
//     dummy → [1] → [2] → [6] → [6] → [3] → null
//              ↑
//             cur
//
// 第一轮：cur.next.val = 1，不是 6 → cur 后移
//     dummy → [1] → [2] → [6] → [6] → [3] → null
//                     ↑
//                    cur
//
// 第二轮：cur.next.val = 2，不是 6 → cur 后移
//     dummy → [1] → [2] → [6] → [6] → [3] → null
//                             ↑
//                            cur
//
// 第三轮：cur.next.val = 6，命中！→ cur = cur.next.next
//     dummy → [1] → [2] → [6] → [3] → null
//                             ↑
//                            cur (cur 没动！因为新的 cur.next=[3] 还没检查)
//
// 第四轮：cur.next.val = 3，不是 6 → cur 后移
//     dummy → [1] → [2] → [3] → null
//                                    ↑
//                                   cur (cur.next == null，循环结束)
//
// 返回 dummy.next → [1] → [2] → [3] → null  ✓
//
// 错误做法对比（你的原思路）：
//     删除后还执行 node = node.next
//     → 会跳过被删节点后面的那个节点，漏检查！


// 变体：不用哨兵节点（需要单独处理头节点），对比一下复杂度
class SolutionWithoutSentinel {
    public ListNode removeElements(ListNode head, int val) {
        // 先处理头节点就是要删的情况（可能连续多个）
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 此时 head 要么为 null，要么 val ≠ val
        if (head == null) return null;

        // 处理后面的节点
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
// 对比：
//   哨兵版：一处循环，逻辑统一，没有特殊分支
//   非哨兵版：头节点单独处理，head 可能连续被删需要 while，代码分散
//   → 哨兵节点让代码更简洁，这就是为什么之前学的单链表要用哨兵！
 */

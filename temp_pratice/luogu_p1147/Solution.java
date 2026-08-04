package temp_pratice.luogu_p1147;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 第一遍遍历：统计节点总数
        int count = 0;          // 从 0 开始
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        // 2. 使用 dummy 节点，统一处理（包括删除头节点的情况）
        ListNode dummy = new ListNode(0, head);
        ListNode tempnode = dummy;

        // 3. 移动到要删除节点的前一个位置
        for (int i = 0; i < count - n; i++) {
            tempnode = tempnode.next;
        }

        // 4. 删除目标节点
        tempnode.next = tempnode.next.next;

        return dummy.next;  // 返回真正的头节点
    }
}

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         //初始化节点个数
//         int count = 1;
//         ListNode node = head;
//         while(node != null){
//             count++;
//             node = node.next;
//         }
        
//         ListNode tempnode = head;
//         //删除操作
//         for(int i = 1;i < count - n;i++){
//             tempnode = tempnode.next;
//         }
//         tempnode.next = tempnode.next.next;
//     }
//     return head;
// }

/*
 * ============================================================
 * LeetCode 19. 删除链表的倒数第 N 个结点 — 正解
 * ============================================================
 *
 * 【解法一：两遍遍历】（你的思路，修正后）
 *
 * 思路：
 *   第一遍遍历统计节点总数 count；
 *   第二遍借助 dummy 节点走到待删除节点的前驱，然后跳过目标节点。
 *
 * 关键修正点（对照你原来的错误）：
 *   1. count 初始化为 0（不是 1），否则节点数会多算 1 个。
 *   2. 引入 dummy 虚拟头节点统一处理所有情况（尤其是删除头节点时）。
 *   3. return dummy.next 而不是 head（head 可能已经被删掉了）。
 *
 * 时间复杂度 O(L)，空间复杂度 O(1)
 *
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 第一遍：统计节点总数
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        // 第二遍：找到倒数第 n 个节点的前驱并删除
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for (int i = 0; i < count - n; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }
}
 *
 *
 * 【解法二：快慢指针 / 一遍遍历】
 *
 * 思路：
 *   快指针先走 n+1 步，然后快慢指针同时走到底；
 *   此时慢指针正好停在待删除节点的前驱，直接跳过即可。
 *
 *   同样需要 dummy 节点处理删除头节点的情况。
 *
 * 时间复杂度 O(L)，空间复杂度 O(1)
 *
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针先走 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时走到底
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时 slow 指向待删除节点的前驱
        slow.next = slow.next.next;

        return dummy.next;
    }
}
*/
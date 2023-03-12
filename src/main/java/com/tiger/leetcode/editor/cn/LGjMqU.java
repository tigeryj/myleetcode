// [剑指 Offer II 026] 重排链表
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
//
// Related Topics 栈 递归 链表 双指针 👍 93 👎 0


package com.tiger.leetcode.editor.cn;

public class LGjMqU {
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        solution.reorderList(l1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {

            // 获取中心节点
            ListNode mid = getMid(head);

            // 第二条链表头
            ListNode l2 = mid.next;

            // 断掉
            mid.next = null;

            // 反转第二条链表
            l2 = reverse(l2);

            merge(head, l2);
        }

        /**
         * 合并两个链表
         * @param l1
         * @param l2
         * @return
         */
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1), cur = dummy;

            while (l1 != null || l2 != null) {
                if (l1 != null) {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                }
                if (l2 != null) {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }
            return dummy.next;
        }

        /**
         * 获取中心节点
         *
         * @param l
         * @return
         */
        private ListNode getMid(ListNode l) {
            ListNode fast = l, slow = l;

            while (fast != null && fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode l) {
            ListNode newHead = null, cur = l;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = next;
            }
            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

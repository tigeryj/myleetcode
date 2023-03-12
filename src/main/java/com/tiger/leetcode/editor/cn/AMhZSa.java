// [剑指 Offer II 027] 回文链表
//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
//
// Related Topics 栈 递归 链表 双指针 👍 102 👎 0


package com.tiger.leetcode.editor.cn;

public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        solution.isPalindrome(l1);
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
        public boolean isPalindrome(ListNode head) {
            ListNode l1 = head;
            ListNode mid = getMid(head);

            ListNode l2 = mid.next;
            mid.next = null;

            l2 = reverse(l2);
            while (l2 != null) {
                if (l1.val != l2.val) return false;
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
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

        /**
         * 反转链表
         *
         * @param l
         * @return
         */
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

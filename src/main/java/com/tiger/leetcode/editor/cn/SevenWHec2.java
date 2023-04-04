// [剑指 Offer II 077] 链表排序
//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 114 👎 0


package com.tiger.leetcode.editor.cn;

public class SevenWHec2 {
    public static void main(String[] args) {
        Solution solution = new SevenWHec2().new Solution();
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode s = dummy, f = dummy;
            while (f != null && f.next != null) {
                f = f.next.next;
                s = s.next;
            }
            ListNode second = s.next;
            s.next = null;
            return merge(sortList(dummy.next), sortList(second));
        }
        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            cur.next = left == null ? right : left;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

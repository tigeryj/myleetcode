//21.合并两个有序链表
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		Solution solution = new MergeTwoSortedLists().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		//Date:2020-10-05 23:11:59
		//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(-1);
			ListNode p1 = dummy, p2 = l1, p3 = l2;
			while (p2 != null || p3 != null) {
				if (p2 == null) {
					p1.next = p3;
					p3 = p3.next;
				} else if (p3 == null || p2.val < p3.val) {
					p1.next = p2;
					p2 = p2.next;
				} else {
					p1.next = p3;
					p3 = p3.next;
				}
				p1 = p1.next;
			}
			return dummy.next;
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)
	class SolutionV1 {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode dumbNode = new ListNode(0);
			ListNode run = dumbNode;
			ListNode l = l1;
			ListNode r = l2;
			while (l != null || r != null) {
				if (l == null) {
					run.next = new ListNode(r.val);
					r = r.next;
				} else if (r == null || l.val <= r.val) {
					run.next = new ListNode(l.val);
					l = l.next;
				} else {
					run.next = new ListNode(r.val);
					r = r.next;
				}
				run = run.next;
			}
			return dumbNode.next;
		}
	}

}
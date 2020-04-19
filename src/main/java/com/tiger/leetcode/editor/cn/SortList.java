//148.排序链表
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class SortList {
	public static void main(String[] args) {
		Solution solution = new SortList().new Solution();
		ListNode node = solution.sortList(Utils.createList(new int[]{9, 4, 6, -1, 7, 2}));
		Utils.printList(node);
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
		/**
		 * list: n0->n1->n2->n3->n4->n5->n6->n7->n8 length =9;
		 * size=1,2,4,8,
		 */

		public ListNode sortList(ListNode head) {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			int length = 0;
			ListNode tmp = dummy;
			while (tmp.next != null) {
				length++;
				tmp = tmp.next;
			}
			for (int sz = 1; sz < length; sz <<= 1) {
				ListNode cur = dummy.next, tail = dummy;
				while (cur != null) {
					ListNode left = cur;
					ListNode right = cut(left, sz);

					cur = cut(right, sz);

					tail.next = merge(left, right);

					while (tail.next != null) {
						tail = tail.next;
					}
				}
			}
			return dummy.next;
		}

		private ListNode cut(ListNode left, int sz) {
			ListNode dummy = new ListNode(-1);
			dummy.next = left;
			ListNode cur = dummy;
			while (cur.next != null && sz-- > 0) {
				cur = cur.next;
			}
			if (cur.next == null) return null;

			ListNode next = cur.next;
			cur.next = null;
			return next;
		}


		//自顶向下
		public ListNode sortListUB(ListNode head) {
			if (head == null || head.next == null) return head;

			ListNode slow = head, fast = head.next;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode mid = slow.next;
			slow.next = null;

			ListNode left = sortList(head);
			ListNode right = sortList(mid);

			return merge(left, right);
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
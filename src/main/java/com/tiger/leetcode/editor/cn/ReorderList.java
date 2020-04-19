//143.重排链表
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

import java.util.ArrayList;


public class ReorderList {
	public static void main(String[] args) {
		Solution solution = new ReorderList().new Solution();
		ListNode list = Utils.createList(new int[]{1, 2, 3, 4, 5});
		solution.reorderList(list);
		Utils.printList(list);
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
		 * The problems has 3 ways to deal it.
		 * 1way:hash way.
		 * 2way:recursive way.
		 * 3way:iterative way.
		 */
		//iterative
		public void reorderList(ListNode head) {
			if (head == null || head.next == null) return;

			ListNode mid = getMid(head);
			ListNode second = mid.next;
			mid.next = null;
			ListNode reversed = reverse(second);

			merge(head, reversed);
		}

		private ListNode merge(ListNode head, ListNode reversed) {
			ListNode dummy = new ListNode(-1);
			ListNode cur = dummy;
			ListNode l1 = head, l2 = reversed;

			while (l1 != null || l2 != null) {
				if (l1 != null) {
					cur.next = l1;
					cur = l1;
					l1 = l1.next;
				}
				if (l2 != null) {
					cur.next = l2;
					cur = l2;
					l2 = l2.next;
				}
			}
			return dummy.next;
		}

		private ListNode reverse(ListNode node) {
			ListNode behind = null, cur = node;
			while (cur.next != null) {
				ListNode next = cur.next;
				cur.next = behind;
				behind = cur;
				cur = next;
			}
			cur.next = behind;
			return cur;
		}

		private ListNode getMid(ListNode head) {
			ListNode fast = head, slow = head;
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}

		/*=======================================================================================================================*/
		/*=======================================================================================================================*/
		// recursive
		public void reorderListV2(ListNode head) {
			if (head == null) return;
			int size = 0;
			ListNode cur = head;
			while (cur != null) {
				cur = cur.next;
				size++;
			}
			reorderList(head, size);
		}

		private ListNode reorderList(ListNode head, int size) {
			if (size == 1) return head;
			if (size == 2) return head.next;

			ListNode orderedTail = reorderList(head.next, size - 2);
			ListNode node = orderedTail.next;
			orderedTail.next = orderedTail.next.next;
			node.next = head.next;
			head.next = node;
			return orderedTail;
		}

		/*=======================================================================================================================*/
		/*=======================================================================================================================*/
		//hash
		public void reorderListV1(ListNode head) {
			if (head == null) return;
			ListNode tmp = head;
			ArrayList<ListNode> list = new ArrayList<>();
			while (tmp != null) {
				list.add(tmp);
				tmp = tmp.next;
			}

			int l = 0, r = list.size() - 1;

			while (l < r) {
				list.get(l).next = list.get(r);
				if (l + 1 < r) {
					list.get(r).next = list.get(l + 1);
				}
				l++;
				r--;
			}
			list.get(l).next = null;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
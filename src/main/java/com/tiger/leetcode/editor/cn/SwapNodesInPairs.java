//24.两两交换链表中的节点
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class SwapNodesInPairs {
	public static void main(String[] args) {
		Solution solution = new SwapNodesInPairs().new Solution();
		ListNode listNode = solution.swapPairs(Utils.createList(new int[]{}));
		Utils.printList(listNode);
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
		public ListNode swapPairs(ListNode head) {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode node1 = head, preTail = dummy;
			while (node1 != null && node1.next != null) {
				ListNode node2 = node1.next;
				ListNode node3 = node2.next;

				preTail.next = node2;
				node2.next = node1;
				preTail = node1;
				node1 = node3;
			}
			preTail.next = node1;

			return dummy.next;
		}

		public ListNode swapPairsV1(ListNode head) {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode cur = head, preTail = dummy;
			while (cur != null && cur.next != null) {
				preTail.next = cur.next;
				preTail = cur;

				ListNode tmp = cur.next.next;
				cur.next.next = cur;
				cur = tmp;
			}
			preTail.next = cur;

			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
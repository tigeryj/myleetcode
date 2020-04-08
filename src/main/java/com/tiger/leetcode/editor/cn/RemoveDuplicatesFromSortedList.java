//83.删除排序链表中的重复元素
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		solution.deleteDuplicates(node1);
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
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null) return head;

			ListNode valid = head, cur = valid.next;
			while (cur != null) {
				if (cur.val != valid.val) {
					valid.next = cur;
					valid = cur;
				}
				cur = cur.next;
			}
			valid.next = null;
			return head;
		}

		//recursive
		public ListNode deleteDuplicatesV1(ListNode head) {
			if (head == null || head.next == null) return head;
			head.next = deleteDuplicates(head.next);
			if (head.val == head.next.val) head.next = head.next.next;
			return head;
		}

		public ListNode deleteDuplicates2(ListNode head) {

			if (head == null) return head;
			ListNode validNode = head, node = head.next;
			while (node != null) {
				if (node.val != validNode.val) {
					validNode.next = node;
					validNode = validNode.next;
				}

				node = node.next;
			}
			validNode.next = null;
			return head;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
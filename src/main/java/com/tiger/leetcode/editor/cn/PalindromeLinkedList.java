//234.回文链表
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		Solution solution = new PalindromeLinkedList().new Solution();
		System.out.println(solution.isPalindrome(Utils.createList(new int[]{1, 0, 1})));
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

		//第一次找中点的时候就把前面一段链表反转
		public boolean isPalindrome(ListNode head) {
			if (head == null || head.next == null) return true;

			ListNode slow = head, fast = head, behind = null;

			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				ListNode slowNext = slow.next;
				slow.next = behind;
				behind = slow;
				slow = slowNext;
			}
			//size为奇数，中间数不参与比较
			if (fast != null) {
				slow = slow.next;
			}
			//slow为后面一段的链表头，behind为前面一段表头
			while (slow != null && behind != null) {
				if (slow.val != behind.val) return false;
				slow = slow.next;
				behind = behind.next;
			}
			return true;
		}

		public boolean isPalindromeV1(ListNode head) {
			if (head == null || head.next == null) return true;
			ListNode l1 = head;
			ListNode mid = getMid(l1);

			ListNode other = mid.next;
			mid.next = null;

			ListNode l2 = reverse(other);

			while (l1 != null && l2 != null) {
				if (l1.val != l2.val) return false;
				l1 = l1.next;
				l2 = l2.next;
			}
			return true;
		}

		private ListNode reverse(ListNode node) {
			ListNode behind = null, cur = node;
			while (cur != null) {
				ListNode next = cur.next;
				cur.next = behind;
				behind = cur;
				cur = next;
			}
			return behind;
		}

		private ListNode getMid(ListNode head) {
			ListNode fast = head, slow = head;
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
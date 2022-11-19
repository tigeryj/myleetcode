//445.两数相加 II
//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。 
//
// 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 进阶: 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 示例: 
//
// 
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
// 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

import java.util.Stack;

public class AddTwoNumbersIi {
	public static void main(String[] args) {
		Solution solution = new AddTwoNumbersIi().new Solution();
		ListNode listNode = solution.addTwoNumbers(Utils.createList(new int[]{7, 3}), Utils.createList(new int[]{0}));
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
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			Stack<Integer> st1 = new Stack();
			Stack<Integer> st2 = new Stack();

			while (l1 != null || l2 != null) {
				if (l1 != null) {
					st1.push(l1.val);
					l1 = l1.next;
				}
				if (l2 != null) {
					st2.push(l2.val);
					l2 = l2.next;
				}
			}
			int append = 0;
			ListNode newHead = null, head = null;
			int val1, val2, sum;
			while (!st1.isEmpty() || !st2.isEmpty() || append != 0) {
				val1 = st1.empty() ? 0 : st1.pop();
				val2 = st2.empty() ? 0 : st2.pop();
				sum = val1 + val2 + append;
				append = sum / 10;
				newHead = new ListNode(sum % 10);
				newHead.next = head;
				head = newHead;
			}
			return newHead;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
//82.删除排序链表中的重复元素 II
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListIi {
	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
		ListNode listNode = solution.deleteDuplicates(Utils.createList(new int[]{1, 1, 1, 2}));
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
		public ListNode deleteDuplicates(ListNode head) {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;

			ListNode pre = dummy, cur = dummy.next;

			while (cur != null) {
				if (cur.next != null && cur.val == cur.next.val) {
					while (cur.next != null && cur.val == cur.next.val) {
						cur = cur.next;
					}
					pre.next = cur.next;
				} else {
					pre = cur;
				}
				cur = cur.next;
			}
			return dummy.next;
		}

		//bad way!
		public ListNode deleteDuplicatesV1(ListNode head) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;

			Set<Integer> set = new HashSet<>();
			Set<Integer> dupSet = new HashSet<>();
			ListNode pre = dummy, cur = head;

			while (head != null) {
				if (set.contains(head.val)) {
					dupSet.add(head.val);
				} else {
					set.add(head.val);
				}
				head = head.next;
			}

			while (cur != null) {
				if (dupSet.contains(cur.val)) {
					pre.next = cur.next;
				} else {
					pre = cur;
				}
				cur = cur.next;
			}
			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
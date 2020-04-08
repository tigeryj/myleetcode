//203.移除链表元素
//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class RemoveLinkedListElements {
	public static void main(String[] args) {
		Solution solution = new RemoveLinkedListElements().new Solution();
		ListNode listNode = solution.removeElements(Utils.createList(new int[]{1, 1}), 1);
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
		public ListNode removeElements(ListNode head, int val) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;

			ListNode pre = dummy, cur = head;
			while (cur != null) {
				if (cur.val == val) {
					pre.next = cur.next;
				} else {
					pre = cur;
				}
				cur = cur.next;
			}
			return dummy.next;
		}

		//recursive
		public ListNode removeElementsV1(ListNode head, int val) {
			if (head == null) return null;
			ListNode listWithOutVal = removeElements(head.next, val);
			if (head.val == val) {
				return listWithOutVal;
			} else {
				head.next = listWithOutVal;
				return head;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
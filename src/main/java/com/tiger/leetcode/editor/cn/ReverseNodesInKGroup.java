//25.K 个一组翻转链表
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;


import com.tiger.utils.Utils;

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		Solution solution = new ReverseNodesInKGroup().new Solution();
		ListNode node = solution.reverseKGroup(Utils.createList(new int[]{1, 2, 3, 4, 5, 6, 7}), 3);
		Utils.printList(node);
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
			if (head == null || k < 1) return head;

			ListNode cur = head;
			for (int i = 0; i < k - 1; i++) {
				cur = cur.next;
				if (cur == null) return head;
			}
			ListNode other = cur.next;
			cur.next = null;
			ListNode newHead = reverse(head);
			head.next = reverseKGroup(other, k);
			return newHead;
		}
		private ListNode reverse(ListNode node) {
			ListNode head = null;
			while (node != null) {
				ListNode next = node.next;
				node.next = head;
				head = node;
				node = next;
			}
			return head;
		}
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class SolutionV1 {
		public ListNode reverseKGroup(ListNode head, int k) {
			//设置哑结点
			ListNode dummy = new ListNode(-1);
			ListNode preTail = dummy;
			preTail.next = head;

			ListNode start = head;
			while (start != null) {
				//向后遍历k个判断是否是最后一组
				ListNode end = start;
				for (int i = 1; i < k && end != null; i++) {
					end = end.next;
				}
				if (end == null) {
					preTail.next = start;
					break;
				}

				//设定下次迭代起始点
				ListNode next = end.next;

				//为了使用反转链表方法
				end.next = null;

				//前后连接
				preTail.next = reverseList(start);

				preTail = start;
				start = next;
			}
			return dummy.next;
		}

		private ListNode reverseList(ListNode start) {
			ListNode cur = start;
			ListNode pre = null;
			while (cur != null) {
				ListNode next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			return pre;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
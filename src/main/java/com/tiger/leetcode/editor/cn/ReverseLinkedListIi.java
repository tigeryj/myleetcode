//92.反转链表 II
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class ReverseLinkedListIi {
	public static void main(String[] args) {
		Solution solution = new ReverseLinkedListIi().new Solution();
		ListNode list = Utils.createList(new int[]{1, 2, 3, 4, 5});
		ListNode node = solution.reverseBetween(list, 2, 4);
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

		//Date:2020-10-05 15:25:36
		//执行耗时:0 ms,击败了100.00% 的Java用户
		public ListNode reverseBetween(ListNode head, int m, int n) {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode preM = dummy;
			for (int i = 0; i < m - 1; i++) {
				preM = preM.next;
			}

			ListNode cur = preM.next;
			ListNode newHead = null;

			for (int i = m; i <= n; i++) {
				ListNode next = cur.next;
				cur.next = newHead;
				newHead = cur;
				cur = next;
			}

			//尾指针拼接
			preM.next.next = cur;
			//头拼接
			preM.next = newHead;

			return dummy.next;
		}

	}

	//leetcode submit region end(Prohibit modification and deletion)
	class SolutionV1 {
		//头插法
		public ListNode reverseBetweenV1(ListNode head, int m, int n) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;

			ListNode preM = dummy;
			ListNode mNode = head;

			for (int i = 1; i < m; i++) {
				preM = mNode;
				mNode = mNode.next;
			}

			ListNode cur = mNode;
			for (int i = 0; i < n - m; i++) {
				ListNode next = cur.next;

				cur.next = cur.next.next;

				next.next = preM.next;

				preM.next = next;
			}
			return dummy.next;
		}

	}


}
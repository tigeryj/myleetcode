//剑指 Offer 24.反转链表
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

public class FanZhuanLianBiaoLcof {
	public static void main(String[] args) {
		Solution solution = new FanZhuanLianBiaoLcof().new Solution();
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
	//Date:2020-07-03 20:30:49
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	//recursive way
	class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null || head.next == null) return head;

			ListNode tail = head.next;
			ListNode reversedHead = reverseList(head.next);
			tail.next = head;
			head.next = null;
			return reversedHead;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	class SolutionV1 {
		public ListNode reverseList(ListNode head) {
			if (head == null) return null;
			ListNode behind = null, cur = head, next = null;
			while (cur != null) {
				next = cur.next;
				cur.next = behind;
				behind = cur;
				cur = next;
			}
			return behind;
		}
	}

}
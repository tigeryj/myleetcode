//剑指 Offer 22.链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针

package com.tiger.leetcode.editor.cn;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
	public static void main(String[] args) {
		Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
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
	//Date:2020-07-03 19:55:56
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public ListNode getKthFromEnd(ListNode head, int k) {
			if (head == null) return null;
			ListNode pre = head, second = head;
			for (int i = 0; i < k && pre != null; i++) {
				pre = pre.next;
			}
			while (pre != null) {
				pre = pre.next;
				second = second.next;
			}
			return second;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
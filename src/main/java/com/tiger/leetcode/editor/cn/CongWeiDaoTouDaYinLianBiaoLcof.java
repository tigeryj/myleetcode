//剑指 Offer 06.从尾到头打印链表
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//

package com.tiger.leetcode.editor.cn;

public class CongWeiDaoTouDaYinLianBiaoLcof {
	public static void main(String[] args) {
		Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
	//Date:2020-06-27 16:45:47
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public int[] reversePrint(ListNode head) {
			if (head == null) return new int[0];
			int size = 0;
			ListNode cur = head;
			while (cur != null) {
				size++;
				cur = cur.next;
			}
			int[] res = new int[size];
			int index = size - 1;

			cur = head;
			while (cur != null) {
				res[index] = cur.val;
				index--;
				cur = cur.next;
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
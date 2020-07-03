//剑指 Offer 25.合并两个排序的链表
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法

package com.tiger.leetcode.editor.cn;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
	public static void main(String[] args) {
		Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-07-03 20:25:58
	//解答成功: 执行耗时:1 ms,击败了99.33% 的Java用户
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null) return l2;
			if (l2 == null) return l1;

			ListNode i = l1;
			ListNode j = l2;
			ListNode dummy = new ListNode(-1), tail = dummy;
			while (i != null || j != null) {
				ListNode cur;
				if (i == null) {
					cur = new ListNode(j.val);
					j = j.next;
				} else if (j == null) {
					cur = new ListNode(i.val);
					i = i.next;
				} else if (i.val < j.val) {
					cur = new ListNode(i.val);
					i = i.next;
				} else {
					cur = new ListNode(j.val);
					j = j.next;
				}
				tail.next = cur;
				tail = cur;
			}
			return dummy.next;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-03 20:15:07
	//执行耗时:1 ms,击败了99.33% 的Java用户
	class SolutionV1 {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null) return l2;
			if (l2 == null) return l1;

			ListNode cur;
			if (l1.val < l2.val) {
				cur = l1;
				l1 = l1.next;
			} else {
				cur = l2;
				l2 = l2.next;
			}
			cur.next = mergeTwoLists(l1, l2);

			return cur;
		}
	}

}
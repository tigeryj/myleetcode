//86.分隔链表
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class PartitionList {
	public static void main(String[] args) {
		Solution solution = new PartitionList().new Solution();
		ListNode partition = solution.partition(Utils.createList(new int[]{1, 4, 3, 2, 5, 2}), 3);
		Utils.printList(partition);
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
		public ListNode partition(ListNode head, int x) {
			ListNode lessDummy = new ListNode(0), lessTail = lessDummy;

			ListNode otherDummy = new ListNode(0), otherTail = otherDummy;

			ListNode cur = head;
			while (cur != null) {
				if (cur.val < x) {
					lessTail.next = cur;
					lessTail = lessTail.next;
				} else {
					otherTail.next = cur;
					otherTail = otherTail.next;
				}
				cur = cur.next;
			}

			lessTail.next = otherDummy.next;

			otherTail.next = null;

			return lessDummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
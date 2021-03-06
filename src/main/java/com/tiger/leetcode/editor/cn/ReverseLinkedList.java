//206.反转链表
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Solution solution = new ReverseLinkedList().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		//头插法
		public ListNode reverseList(ListNode head) {
			ListNode dummyNode = new ListNode(-1);
			while (head != null) {
				ListNode next = head.next;
				head.next = dummyNode.next;
				dummyNode.next = head;
				head = next;
			}
			return dummyNode.next;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	class SolutionV1 {

		//iterative
		public ListNode reverseList(ListNode head) {

			ListNode pre = null;
			ListNode cur = head;

			while (cur != null) {
				ListNode tmp = cur.next;
				cur.next = pre;
				pre = cur;
				cur = tmp;
			}
			return pre;
		}

		//recursive
		public ListNode reverseListV1(ListNode head) {
			if (head == null || head.next == null) return head;

			ListNode node = reverseList(head.next);
			head.next.next = head;
			head.next = null;

			return node;
		}
	}

}
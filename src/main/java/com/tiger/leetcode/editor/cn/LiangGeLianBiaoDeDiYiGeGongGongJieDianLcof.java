//剑指 Offer 52.两个链表的第一个公共节点
//输入两个链表，找出它们的第一个公共节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/ 
// 
// Related Topics 链表

package com.tiger.leetcode.editor.cn;

public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
	public static void main(String[] args) {
		Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) {
	 * val = x;
	 * next = null;
	 * }
	 * }
	 */
	//Date:2020-07-12 10:31:57
	//解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户
	//优雅多了。。。
	public class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			if (headA == null || headB == null) return null;
			ListNode a = headA, b = headB;
			while (a != b) {
				a = a == null ? headB : a.next;
				b = b == null ? headA : b.next;
			}
			return a;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-11 23:52:46
	//解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户
	//这个写的太挫了
	public class SolutionV1 {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			if (headA == null || headB == null) return null;

			int size = 0;
			ListNode runA = headA, runB = headB;
			while (runA != null && runB != null) {
				runA = runA.next;
				runB = runB.next;
			}

			ListNode l = runA == null ? headB : headA;
			ListNode s = runA == null ? headA : headB;

			while (runA != null) {
				size++;
				runA = runA.next;
			}
			while (runB != null) {
				size++;
				runB = runB.next;
			}


			while (size > 0) {
				l = l.next;
				size--;
			}

			while (l != null && s != null) {
				if (l == s) return l;
				l = l.next;
				s = s.next;
			}

			return null;
		}
	}

}
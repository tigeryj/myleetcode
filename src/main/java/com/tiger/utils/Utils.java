package com.tiger.utils;

import com.tiger.leetcode.editor.cn.ListNode;

/**
 * @auther Jack
 * @date 2020/4/5 15:05
 */

public class Utils {
	public static ListNode createList(int[] arr) {
		if (arr == null || arr.length == 0) return null;
		ListNode head = new ListNode(arr[0]);
		ListNode cur = head;
		for (int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return head;
	}

	public static void printList(ListNode listNode) {
		int count = 0;
		while (listNode != null) {
			System.out.print(listNode.val + "-->");
			listNode = listNode.next;
			if (++count == 100) {
				break;
			}
		}
		System.out.println("NULL");
	}
}

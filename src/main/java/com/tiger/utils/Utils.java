package com.tiger.utils;

import com.tiger.leetcode.editor.cn.ListNode;
import com.tiger.leetcode.editor.cn.TreeNode;

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

	public static TreeNode createTree(Integer[] arr) {
		if (arr == null || arr.length == 0) return null;

		TreeNode[] nodes = new TreeNode[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				nodes[i] = new TreeNode(0);
				nodes[i].val = arr[i];
			} else {
				nodes[i] = null;
			}
		}

		for (int i = 0; i <= (arr.length - 2) / 2; i++) {
			TreeNode node = nodes[i];
			if (node == null) continue;

			if (2 * i + 1 < arr.length) {
				node.left = nodes[2 * i + 1];
			}
			if (2 * i + 2 < arr.length) {
				node.right = nodes[2 * i + 2];
			}
		}
		return nodes[0];
	}
}

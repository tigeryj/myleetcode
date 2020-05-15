//450.删除二叉搜索树中的节点
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class DeleteNodeInABst {
	public static void main(String[] args) {
		Solution solution = new DeleteNodeInABst().new Solution();
		TreeNode treeNode = solution.deleteNode(Utils.createTree(new Integer[]{2, 1, 3}), 2);
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public TreeNode deleteNode(TreeNode node, int key) {
			if (node == null) return node;

			if (key < node.val) {
				node.left = deleteNode(node.left, key);
			} else if (key > node.val) {
				node.right = deleteNode(node.right, key);
			} else {
				if (node.left == null) {
					return node.right;
				}
				if (node.right == null) {
					return node.left;
				}
				TreeNode rightMin = min(node.right);
				node.right = removeMin(node.right);
				rightMin.left = node.left;
				rightMin.right = node.right;
				return rightMin;
			}
			return node;
		}

		private TreeNode removeMin(TreeNode node) {
			if (node == null) return node;
			if (node.left == null) {
				TreeNode right = node.right;
				node.right = null;
				return right;
			}
			node.left = removeMin(node.left);
			return node;
		}

		private TreeNode min(TreeNode node) {
			if (node == null || node.left == null) return node;
			return min(node.left);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
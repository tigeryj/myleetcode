//257.二叉树的所有路径
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索

package com.tiger.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePaths().new Solution();
		List<String> list = solution.binaryTreePaths(new TreeNode(1));
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
		/**
		 * Non-recursive
		 */
		public List<String> binaryTreePaths(TreeNode root) {
			List<String> res = new LinkedList<>();
			if (root == null) return res;
			Stack<Pair<TreeNode, String>> stack = new Stack<>();

			stack.add(new Pair(root, String.valueOf(root.val)));

			while (!stack.isEmpty()) {
				Pair<TreeNode, String> pop = stack.pop();
				TreeNode node = pop.getKey();
				String path = pop.getValue();

				if (node.left == null && node.right == null) res.add(path);
				if (node.left != null) {
					stack.add(new Pair<>(node.left, path + "->" + node.left.val));
				}
				if (node.right != null) {
					stack.add(new Pair<>(node.right, path + "->" + node.right.val));
				}
			}

			return res;
		}

		/**
		 * recursive
		 */
		public List<String> binaryTreePathsV3(TreeNode root) {
			List<String> res = new LinkedList<>();
			if (root == null) return res;

			if (root.left == null && root.right == null) res.add(String.valueOf(root.val));

			List<String> leftPath = binaryTreePathsV3(root.left);
			for (String path : leftPath) {
				StringBuilder sb = new StringBuilder();
				sb.append(root.val);
				sb.append("->");
				sb.append(path);
				res.add(sb.toString());
			}

			List<String> rightPath = binaryTreePathsV3(root.right);
			for (String path : rightPath) {
				StringBuilder sb = new StringBuilder();
				sb.append(root.val);
				sb.append("->");
				sb.append(path);
				res.add(sb.toString());
			}

			return res;
		}

		/**
		 * V2,和v1没有本质区别
		 */
		public List<String> binaryTreePathsV2(TreeNode root) {
			List<String> res = new LinkedList<>();
			if (root == null) return res;

			DFS(root, res, "");
			return res;
		}

		private void DFS(TreeNode node, List<String> res, String path) {
			if (node == null) return;

			path += node.val;
			if (node.left == null && node.right == null) {
				res.add(path);
			}

			DFS(node.left, res, path + "->");
			DFS(node.right, res, path + "->");
		}

		/**
		 * V1
		 */
		public List<String> binaryTreePathsV1(TreeNode root) {
			List<String> res = new LinkedList<>();
			if (root == null) return res;

			binaryTreePathsV3(root, res, String.valueOf(root.val));
			return res;
		}

		private void binaryTreePathsV3(TreeNode node, List<String> res, String path) {
			if (node != null && node.left == null && node.right == null) {
				res.add(path);
				return;
			}

			if (node.left != null) {
				binaryTreePathsV3(node.left, res, path + "->" + node.left.val);
			}

			if (node.right != null) {
				binaryTreePathsV3(node.right, res, path + "->" + node.right.val);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
//199.二叉树的右视图
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeRightSideView().new Solution();
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
		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> res = new LinkedList<>();
			if (root == null) return res;
			int depth = 1;
			DFS(res, root, depth);
			return res;
		}

		private void DFS(List<Integer> res, TreeNode node, int depth) {
			if (node == null) return;

			if (depth > res.size()) {
				res.add(node.val);
			}

			if (node.right != null) DFS(res, node.right, depth + 1);
			if (node.left != null) DFS(res, node.right, depth + 1);
		}

		public List<Integer> rightSideViewV1(TreeNode root) {
			List<Integer> res = new LinkedList<>();
			if (root == null) return res;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode poll = queue.poll();
					if (poll.left != null) queue.add(poll.left);
					if (poll.right != null) queue.add(poll.right);
					if (i == size - 1) {
						res.add(poll.val);
					}
				}
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
//107.二叉树的层次遍历 II
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIi {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> res = new LinkedList<>();
			if (root == null) return res;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int levelSize = queue.size();
				List<Integer> levelList = new LinkedList<>();
				while (levelSize-- > 0) {
					TreeNode remove = queue.remove();
					levelList.add(remove.val);
					if (remove.left != null) queue.offer(remove.left);
					if (remove.right != null) queue.offer(remove.right);
				}
				res.add(0, levelList);
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
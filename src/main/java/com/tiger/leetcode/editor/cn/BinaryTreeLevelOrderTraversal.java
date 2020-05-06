//102.二叉树的层序遍历
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> res = new LinkedList<>();
			if (root == null) return res;

			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				List<Integer> list = new LinkedList<>();
				int levelSize = queue.size();
				while (levelSize-- > 0) {
					TreeNode remove = queue.remove();
					list.add(remove.val);
					if (remove.left != null) queue.offer(remove.left);
					if (remove.right != null) queue.offer(remove.right);
				}
				res.add(list);
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
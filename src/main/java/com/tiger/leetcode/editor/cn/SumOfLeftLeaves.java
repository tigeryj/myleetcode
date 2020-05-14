//404.左叶子之和
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树

package com.tiger.leetcode.editor.cn;

public class SumOfLeftLeaves {
	public static void main(String[] args) {
		Solution solution = new SumOfLeftLeaves().new Solution();
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
		public int sumOfLeftLeaves(TreeNode root) {
			return sumOfLeftLeaves(root, false);
		}

		private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
			if (node == null) return 0;

			if (node.left == null && node.right == null && isLeft) return node.val;

			return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
		}

		public int sumOfLeftLeavesV1(TreeNode root) {
			int sum = 0;
			if (root == null) return sum;

			TreeNode left = root.left;
			if (left != null && left.left == null && left.right == null) {
				sum += left.val;
			} else {
				sum += sumOfLeftLeaves(root.left);
			}

			return sum + sumOfLeftLeaves(root.right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
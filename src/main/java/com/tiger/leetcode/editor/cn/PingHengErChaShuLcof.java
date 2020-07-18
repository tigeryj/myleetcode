//剑指 Offer 55 - II.平衡二叉树
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 1 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 43 👎 0

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class PingHengErChaShuLcof {
	public static void main(String[] args) {
		Solution solution = new PingHengErChaShuLcof().new Solution();
		System.out.println(solution.isBalanced(Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
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
	//Date:2020-07-18 16:43:04
	//解答成功: 执行耗时:1 ms,击败了99.91% 的Java用户
	class Solution {
		public boolean isBalanced(TreeNode root) {
			if (root == null) return true;

			return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
		}

		private int depth(TreeNode node) {
			if (node == null) return 0;

			return Math.max(depth(node.left), depth(node.right)) + 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-18 16:20:46
	//解答成功: 执行耗时:1 ms,击败了99.91% 的Java用户
	class SolutionV1 {
		public boolean isBalanced(TreeNode root) {
			if (root == null) return true;

			return count(root) == -1 ? false : true;
		}

		private int count(TreeNode node) {
			if (node == null) return 0;

			int left = count(node.left);

			if (left == -1) return -1;

			int right = count(node.right);

			if (right == -1) return -1;

			return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
		}
	}

}
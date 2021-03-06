//剑指 Offer 28.对称的二叉树
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树

package com.tiger.leetcode.editor.cn;

public class DuiChengDeErChaShuLcof {
	public static void main(String[] args) {
		Solution solution = new DuiChengDeErChaShuLcof().new Solution();
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
	//Date:2020-07-04 22:21:17
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public boolean isSymmetric(TreeNode root) {
			return isSymmetric(root, root);
		}

		private boolean isSymmetric(TreeNode node1, TreeNode node2) {
			if (node1 == null && node2 == null) return true;
			if (node1 == null || node2 == null) return false;

			return node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
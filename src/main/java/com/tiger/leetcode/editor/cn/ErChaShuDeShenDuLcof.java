//剑指 Offer 55 - I.二叉树的深度
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 28 👎 0

package com.tiger.leetcode.editor.cn;

public class ErChaShuDeShenDuLcof {
	public static void main(String[] args) {
		Solution solution = new ErChaShuDeShenDuLcof().new Solution();
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
	//Date:2020-07-15 20:08:10
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public int maxDepth(TreeNode root) {
			if (root == null) return 0;

			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
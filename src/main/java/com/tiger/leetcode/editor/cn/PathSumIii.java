//437.路径总和 III
//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

public class PathSumIii {
	public static void main(String[] args) {
		Solution solution = new PathSumIii().new Solution();
		System.out.println(solution.pathSum(Utils.createTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
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

		public int pathSum(TreeNode node, int sum) {
			if (node == null) return 0;
			int count = 0;
			count += findSum(node, sum);

			count += pathSum(node.left, sum);
			count += pathSum(node.right, sum);
			return count;
		}

		/**
		 * 以node结点开始的路径，和为target的个数
		 */
		private int findSum(TreeNode node, int target) {
			if (node == null) return 0;
			int count = 0;
			if (node.val == target) count++;

			count += findSum(node.left, target - node.val);
			count += findSum(node.right, target - node.val);
			return count;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
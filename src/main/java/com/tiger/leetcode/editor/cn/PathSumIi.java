//113.路径总和 II
//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi {
	public static void main(String[] args) {
		Solution solution = new PathSumIi().new Solution();
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
		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			List<List<Integer>> res = new LinkedList<>();
			pathSum(root, res, new ArrayList(), sum);
			return res;
		}

		private void pathSum(TreeNode node, List<List<Integer>> res, List<Integer> path, int target) {
			if (node == null) return;

			path.add(node.val);
			if (node.left == null && node.right == null && node.val == target) {
				res.add(new ArrayList<>(path));
			}

			pathSum(node.left, res, path, target - node.val);
			pathSum(node.right, res, path, target - node.val);
			path.remove(path.size() - 1);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
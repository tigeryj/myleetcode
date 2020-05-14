//129.求根到叶子节点数字之和
//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;
import javafx.util.Pair;

import java.util.Stack;

public class SumRootToLeafNumbers {
	public static void main(String[] args) {
		Solution solution = new SumRootToLeafNumbers().new Solution();
		System.out.println(solution.sumNumbers(Utils.createTree(new Integer[]{4, 9, 0, 5, 1})));
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

		public int sumNumbers(TreeNode root) {
			return sumNumbersV1(root, 0);
		}

		//iterative
		public int sumNumbersV2(TreeNode root) {
			int sum = 0;
			if (root == null) return sum;
			Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
			stack.add(new Pair<>(root, root.val));
			while (!stack.isEmpty()) {
				Pair<TreeNode, Integer> pop = stack.pop();
				TreeNode node = pop.getKey();
				if (node.left == null && node.right == null) sum += pop.getValue();
				if (node.left != null) {
					stack.add(new Pair<>(node.left, pop.getValue() * 10 + node.left.val));
				}
				if (node.right != null) {
					stack.add(new Pair<>(node.right, pop.getValue() * 10 + node.right.val));
				}
			}
			return sum;
		}

		/**
		 * recursive
		 */
		private int sumNumbersV1(TreeNode node, int base) {
			if (node == null) return 0;
			base = base * 10 + node.val;
			if (node.left == null && node.right == null) return base;
			return sumNumbersV1(node.left, base) + sumNumbersV1(node.right, base);
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
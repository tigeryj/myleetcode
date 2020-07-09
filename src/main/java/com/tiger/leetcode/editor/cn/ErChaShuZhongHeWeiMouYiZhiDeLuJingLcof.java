//剑指 Offer 34.二叉树中和为某一值的路径
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
	public static void main(String[] args) {
		Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
	//Date:2020-07-09 22:07:39
	//解答成功: 执行耗时:2 ms,击败了40.73% 的Java用户
	class Solution {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();

		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			dfs(root, sum);
			return res;
		}

		private void dfs(TreeNode root, int target) {
			if (root == null) return;
			path.add(root.val);

			target -= root.val;

			if (root.left == null && root.right == null && target == 0) {
				res.add(new ArrayList<>(path));
			}

			dfs(root.left, target);
			dfs(root.right, target);

			path.remove(path.size() - 1);
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
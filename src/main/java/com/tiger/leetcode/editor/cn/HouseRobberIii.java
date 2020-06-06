//337.打家劫舍 III
//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii {
	public static void main(String[] args) {
		Solution solution = new HouseRobberIii().new Solution();
		TreeNode tree = Utils.createTree(new Integer[]{4, 1, null, 2, null, 3});
		System.out.println(solution.rob(tree));
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
	//Date:2020-06-06 22:33:36
	//执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {

		public int rob(TreeNode root) {
			if (root == null) return 0;

			int[] res = tryRob(root);

			return Math.max(res[0], res[1]);
		}

		//res[0]:不偷当前结点的最大利润
		//res[1]:偷当前结点的最大利润
		private int[] tryRob(TreeNode node) {
			if (node == null) return new int[2];

			int[] res = new int[2];
			int[] left = tryRob(node.left);
			int[] right = tryRob(node.right);

			//不偷当前结点，子节点偷或不偷取决收益如何
			res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

			res[1] = left[0] + right[0] + node.val;

			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-06 22:04:08
	//执行耗时:3 ms,击败了59.69% 的Java用户
	//记忆化搜索
	class SolutionV2 {
		Map<TreeNode, Integer> memo = new HashMap<>();

		public int rob(TreeNode root) {
			if (root == null) return 0;

			if (memo.containsKey(root)) return memo.get(root);

			TreeNode left = root.left;
			TreeNode right = root.right;

			int max = Math.max(rob(root.left) + rob(root.right),
				root.val
					+ (left != null ? rob(left.left) + rob(left.right) : 0)
					+ (right != null ? rob(right.left) + rob(right.right) : 0));
			memo.put(root, max);
			return max;
		}
	}

	//Date:2020-06-06 21:55:34
	//执行耗时:1115 ms,击败了9.26% 的Java用户
	//递归回溯
	class SolutionV1 {
		public int rob(TreeNode root) {
			if (root == null) return 0;

			TreeNode left = root.left;
			TreeNode right = root.right;

			return Math.max(rob(root.left) + rob(root.right),
				root.val
					+ (left != null ? rob(left.left) + rob(left.right) : 0)
					+ (right != null ? rob(right.left) + rob(right.right) : 0));
		}
	}

}
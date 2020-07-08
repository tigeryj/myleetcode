//剑指 Offer 32 - III.从上到下打印二叉树 III
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
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
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
	public static void main(String[] args) {
		Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
	//Date:2020-07-08 19:34:35
	//解答成功: 执行耗时:1 ms,击败了99.77% 的Java用户
	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> res = new LinkedList<>();
			if (root == null) return res;
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				LinkedList<Integer> level = new LinkedList<>();
				int levelSize = queue.size();
				while (levelSize != 0) {
					TreeNode poll = queue.poll();
					if ((res.size() & 1) == 0) {
						level.add(poll.val);
					} else {
						level.addFirst(poll.val);
					}
					if (poll.left != null) {
						queue.add(poll.left);
					}
					if (poll.right != null) {
						queue.add(poll.right);
					}
					levelSize--;
				}
				res.add(level);
			}

			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
//剑指 Offer 32 - II.从上到下打印二叉树 II
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiLcof {
	public static void main(String[] args) {
		Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
	//Date:2020-07-07 22:06:50
	//解答成功: 执行耗时:1 ms,击败了93.64% 的Java用户
	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null) return new LinkedList<>();
			LinkedList<List<Integer>> res = new LinkedList();
			LinkedList<TreeNode> list = new LinkedList<>();
			list.add(root);
			while (!list.isEmpty()) {
				int size = list.size();
				List<Integer> levelList = new LinkedList<>();
				while (size > 0) {
					TreeNode poll = list.poll();
					levelList.add(poll.val);

					if (poll.left != null) {
						list.offer(poll.left);
					}
					if (poll.right != null) {
						list.offer(poll.right);
					}
					size--;
				}
				res.add(levelList);
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
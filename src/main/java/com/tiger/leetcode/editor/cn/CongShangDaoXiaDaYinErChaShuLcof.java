//剑指 Offer 32 - I.从上到下打印二叉树
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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

public class CongShangDaoXiaDaYinErChaShuLcof {
	public static void main(String[] args) {
		Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
	//Date:2020-07-07 21:50:08
	//解答成功: 执行耗时:1 ms,击败了99.61% 的Java用户
	//优化：只用一个list
	class Solution {
		public int[] levelOrder(TreeNode root) {
			if (root == null) return new int[0];
			LinkedList<TreeNode> list = new LinkedList<>();
			list.add(root);
			int i = 0;
			while (i < list.size()) {
				TreeNode node = list.get(i);
				if (node.left != null) {
					list.add(node.left);
				}
				if (node.right != null) {
					list.add(node.right);
				}
				i++;
			}
			int[] res = new int[list.size()];
			for (int j = 0; j < res.length; j++) {
				res[j] = list.get(j).val;
			}

			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-07 21:38:03
	//执行耗时:4 ms,击败了16.44% 的Java用户
	class SolutionV1 {
		public int[] levelOrder(TreeNode root) {
			if (root == null) return new int[0];

			LinkedList<TreeNode> queue = new LinkedList<>();
			List<TreeNode> list = new LinkedList<>();

			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode first = queue.removeFirst();
				list.add(first);
				if (first.left != null) {
					queue.add(first.left);
				}
				if (first.right != null) {
					queue.add(first.right);
				}
			}
			int[] res = new int[list.size()];
			for (int i = 0; i < res.length; i++) {
				res[i] = list.get(i).val;
			}

			return res;
		}
	}

}
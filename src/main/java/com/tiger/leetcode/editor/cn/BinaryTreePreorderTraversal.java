//144.二叉树的前序遍历
//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
		//iterative
		public List<Integer> preorderTraversal(TreeNode root) {
			Stack<TreeNode> st = new Stack<>();
			List<Integer> res = new LinkedList<>();
			if (root == null) return res;
			st.add(root);
			while (!st.isEmpty()) {
				TreeNode pop = st.pop();
				res.add(pop.val);
				if (pop.right != null) st.push(pop.right);
				if (pop.left != null) st.push(pop.left);
			}
			return res;
		}

		//recursive
		public List<Integer> preorderTraversalV1(TreeNode root) {
			List<Integer> res = new LinkedList();
			preOrder(res, root);
			return res;
		}

		private void preOrder(List<Integer> res, TreeNode node) {
			if (node == null) return;
			res.add(node.val);
			preOrder(res, node.left);
			preOrder(res, node.right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
//145.二叉树的后序遍历
//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
		List<Integer> res = new LinkedList<>();

		class Node {
			TreeNode treeNode;
			Boolean visited;

			public Node(TreeNode treeNode, Boolean visited) {
				this.treeNode = treeNode;
				this.visited = visited;
			}
		}

		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> res = new LinkedList<>();
			if (root == null) return res;
			Stack<Node> st = new Stack<>();
			st.add(new Node(root, false));
			while (!st.isEmpty()) {
				Node node = st.pop();
				if (node.visited) {
					res.add(node.treeNode.val);
				} else {
					st.add(new Node(node.treeNode, true));
					if (node.treeNode.right != null) {
						st.add(new Node(node.treeNode.right, false));
					}
					if (node.treeNode.left != null) {
						st.add(new Node(node.treeNode.left, false));
					}
				}
			}
			return res;
		}

		//recursive
		public List<Integer> postorderTraversalV1(TreeNode root) {
			if (root == null) return res;
			postOrder(root);
			return res;
		}

		private void postOrder(TreeNode root) {
			if (root == null) return;
			postOrder(root.left);
			postOrder(root.right);
			res.add(root.val);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
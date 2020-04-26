//94.二叉树的中序遍历
//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
		List<Integer> inorderNums = new ArrayList<>();

		class PathNode {
			TreeNode node;
			Boolean visited;

			public PathNode(TreeNode node, Boolean visited) {
				this.node = node;
				this.visited = visited;
			}
		}


		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> res = new LinkedList<>();
			if (root == null) return res;
			Stack<PathNode> st = new Stack<>();
			st.add(new PathNode(root, false));
			while (!st.isEmpty()) {
				PathNode pathNode = st.pop();
				if (pathNode.visited) {
					res.add(pathNode.node.val);
				} else {
					if (pathNode.node.right != null) {
						st.add(new PathNode(pathNode.node.right, false));
					}
					st.add(new PathNode(pathNode.node, true));
					if (pathNode.node.left != null) {
						st.add(new PathNode(pathNode.node.left, false));
					}
				}
			}
			return res;
		}

		public List<Integer> inorderTraversalV1(TreeNode root) {
			inorderTraversalRecursive(root);
			return inorderNums;
		}

		public void inorderTraversalRecursive(TreeNode root) {
			if (root == null) {
				return;
			}
			inorderTraversalRecursive(root.left);
			inorderNums.add(root.val);
			inorderTraversalRecursive(root.right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
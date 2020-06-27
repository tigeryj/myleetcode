//剑指 Offer 07.重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;

public class ZhongJianErChaShuLcof {
	public static void main(String[] args) {
		Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
	//Date:2020-06-27 20:41:16
	//解答成功: 执行耗时:3 ms,击败了82.10% 的Java用户
	class Solution {
		HashMap<Integer, Integer> map = new HashMap<>();

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			for (int i = 0; i < inorder.length; i++) {
				map.put(inorder[i], i);
			}

			return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		}

		private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
			if (pStart > pEnd || iStart > iEnd) return null;

			int k = map.get(preorder[pStart]);

			TreeNode head = new TreeNode(preorder[pStart]);

			head.left = buildTree(preorder, pStart + 1, pStart + k - iStart, inorder, iStart, k - 1);
			head.right = buildTree(preorder, pStart + k - iStart + 1, pEnd, inorder, k + 1, iEnd);
			return head;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-27 17:16:59
	//解答成功: 执行耗时:9 ms,击败了25.17% 的Java用户
	class SolutionV1 {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		}

		private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
			if (pStart > pEnd || iStart > iEnd) return null;

			int k = iStart;
			for (int i = iStart; i <= iEnd; i++) {
				if (inorder[i] == preorder[pStart]) {
					k = i;
					break;
				}
			}

			TreeNode head = new TreeNode(preorder[pStart]);

			head.left = buildTree(preorder, pStart + 1, pStart + k - iStart, inorder, iStart, k - 1);
			head.right = buildTree(preorder, pStart + k - iStart + 1, pEnd, inorder, k + 1, iEnd);
			return head;
		}
	}
}
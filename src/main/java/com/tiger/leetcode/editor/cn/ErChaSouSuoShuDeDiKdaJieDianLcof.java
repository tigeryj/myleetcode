//剑指 Offer 54.二叉搜索树的第k大节点
//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 40 👎 0

package com.tiger.leetcode.editor.cn;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
	public static void main(String[] args) {
		Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-07-17 20:37:57
	//执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		int k;
		int res;

		public int kthLargest(TreeNode root, int k) {
			if (root == null || k < 1) throw new IllegalArgumentException();

			this.k = k;

			dfs(root);

			return res;
		}

		private void dfs(TreeNode node) {
			if (node == null) return;

			dfs(node.right);

			k--;
			if (k == 0) {
				res = node.val;
				return;
			}

			dfs(node.left);
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-17 20:13:30
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	//效率低，计算树的节点个数时，有重复计算。
	class SolutionV1 {
		public int kthLargest(TreeNode root, int k) {
			if (root == null || k < 1) return 0;

			int rightCount = count(root.right);

			if (rightCount == k - 1) {
				return root.val;
			} else if (rightCount > k - 1) {
				return kthLargest(root.right, k);
			} else {
				return kthLargest(root.left, k - rightCount - 1);
			}
		}

		private int count(TreeNode node) {
			if (node == null) return 0;
			return count(node.left) + count(node.right) + 1;
		}
	}

}


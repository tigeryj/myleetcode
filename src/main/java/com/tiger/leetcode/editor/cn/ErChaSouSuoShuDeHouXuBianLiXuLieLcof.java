//剑指 Offer 33.二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
//

package com.tiger.leetcode.editor.cn;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
	public static void main(String[] args) {
		Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
		System.out.println(solution.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
		System.out.println(solution.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-07-08 21:00:43
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public boolean verifyPostorder(int[] postorder) {
			if (postorder == null || postorder.length == 0) return true;

			return verifyPostorder(postorder, 0, postorder.length - 1);
		}

		private boolean verifyPostorder(int[] postorder, int start, int end) {
			if (start + 1 >= end) return true;

			int i = start, next;
			while (i < end && postorder[i] < postorder[end]) {
				i++;
			}
			next = i;
			while (i < end) {
				if (postorder[i] < postorder[end]) return false;
				i++;
			}

			return verifyPostorder(postorder, start, next - 1) && verifyPostorder(postorder, next, end - 1);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
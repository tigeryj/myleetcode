//152.乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

package com.tiger.leetcode.editor.cn;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		Solution solution = new MaximumProductSubarray().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxProduct(int[] nums) {
			if (nums == null || nums.length == 0) return 0;
			int[][] dp = new int[nums.length][2];
			dp[0][0] = nums[0];
			dp[0][1] = nums[0];
			int max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] < 0) {
					dp[i][0] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
					dp[i][1] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
				} else {
					dp[i][0] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
					dp[i][1] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
				}
				max = Math.max(max, dp[i][0]);
			}
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
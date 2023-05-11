//494.目标和
//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划

package com.tiger.leetcode.editor.cn;

public class TargetSum {
	public static void main(String[] args) {
		Solution solution = new TargetSum().new Solution();
		System.out.println(solution.findTargetSumWays(new int[]{1000}, 1000));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	// 转化为01背包问题
	class Solution {
		public int findTargetSumWays(int[] nums, int target) {
			if (nums == null || nums.length == 0) return 0;
			// dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]
			int s = 0;
			for (int n : nums) s += n;
			// s1 - (s - s1) == target, s1 = (s + target) / 2;
			// 如果target是负的，可以转换为正的
			if (target < 0) target = -target;
			if (((s + target) & 1) == 1) return 0;
			int sum = (s + target) / 2;
			int[] dp = new int[sum + 1];
			dp[0] = 1;
			for (int n : nums) {
				for (int j = sum; j >= n; j--) {
					dp[j] = dp[j] + dp[j - n];
				}
			}
			return dp[sum];
		}
	}

	class SolutionV2 {

		public int findTargetSumWays(int[] nums, int S) {
			if (nums == null || nums.length == 0) return 0;
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}
			if (S > sum || S + sum < 0) return 0;

			int delta = sum + 1;

			int[][] dp = new int[nums.length + 1][2 * delta];

			dp[0][0 + delta] = 1;

			for (int i = 1; i <= nums.length; i++) {
				for (int j = -sum; j <= sum; j++) {

					if (j + nums[i - 1] <= sum) {
						dp[i][j + delta] = dp[i - 1][j + nums[i - 1] + delta];
					}

					if (j - nums[i - 1] >= -sum) {
						dp[i][j + delta] += dp[i - 1][j - nums[i - 1] + delta];
					}

				}
			}

			return dp[nums.length][S + delta];
		}
	}


	//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-12 23:19:46
	//执行耗时:379 ms,击败了43.65% 的Java用户
	class SolutionV1 {
		public int findTargetSumWays(int[] nums, int S) {
			return dfs(nums, 0, S);
		}

		private int dfs(int[] nums, int start, int sum) {
			if (start == nums.length - 1 && nums[start] == Math.abs(sum)) {
				if (sum == 0) return 2;
				return 1;
			}

			if (start == nums.length - 1) return 0;

			return dfs(nums, start + 1, sum + nums[start]) + dfs(nums, start + 1, sum - nums[start]);
		}
	}

}
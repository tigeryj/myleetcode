//416.分割等和子集
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划

package com.tiger.leetcode.editor.cn;

public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		Solution solution = new PartitionEqualSubsetSum().new Solution();
		System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
		System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)


	//Date:2020-06-07 20:49:39
	//执行耗时:17 ms,击败了77.90% 的Java用
	class Solution {

		public boolean canPartition(int[] nums) {
			if (nums == null || nums.length < 2) return false;

			int n = nums.length;
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}
			if (sum % 2 != 0) return false;

			boolean[] dp = new boolean[sum / 2 + 1];

			if (nums[0] <= sum / 2) {
				dp[nums[0]] = true;
			}

			for (int i = 1; i < n; i++) {
				for (int count = sum / 2; count >= nums[i]; count--) {
					dp[count] |= dp[count - nums[i]];
				}
			}
			return dp[sum / 2];
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)


	//Date:2020-06-07 18:56:13
	//执行耗时:53 ms,击败了22.00% 的Java用户
	class SolutionV3 {

		public boolean canPartition(int[] nums) {
			if (nums == null || nums.length < 2) return false;

			int n = nums.length;
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}
			if (sum % 2 != 0) return false;

			//dp[i][sum] 表示在0~i的元素能否找到元素和来填充sum
			boolean[][] dp = new boolean[n][sum / 2 + 1];

			if (nums[0] <= sum / 2) {
				dp[0][nums[0]] = true;
			}

			for (int i = 1; i < n; i++) {
				for (int count = 0; count <= sum / 2; count++) {
					dp[i][count] = dp[i - 1][count];
					if (count >= nums[i]) {
						dp[i][count] |= dp[i - 1][count - nums[i]];
					}
				}
			}
			return dp[n - 1][sum / 2];
		}
	}


	//Date:2020-06-07 18:15:59
	//执行耗时:40 ms,击败了36.57% 的Java用户
	class SolutionV2 {
		Boolean[][] memo;

		public boolean canPartition(int[] nums) {
			if (nums == null || nums.length < 2) return false;

			int n = nums.length;
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}
			if (sum % 2 != 0) return false;

			memo = new Boolean[n][sum / 2 + 1];

			return tryPartition(nums, n - 1, sum / 2);
		}

		//nums[0]~nums[index]之前的数字能否正好填充sum
		private boolean tryPartition(int[] nums, int index, int sum) {
			if (sum == 0) return true;

			if (index < 0 || sum < 0) return false;

			if (memo[index][sum] != null) return memo[index][sum];

			memo[index][sum] = tryPartition(nums, index - 1, sum)
				|| tryPartition(nums, index - 1, sum - nums[index]);

			return memo[index][sum];
		}
	}

	//Date:2020-06-07 17:31:24
	//Time Limit Exceeded
	class SolutionV1 {
		public boolean canPartition(int[] nums) {
			if (nums == null || nums.length < 2) return false;

			return dfs(nums, 0, 0);
		}

		private boolean dfs(int[] nums, int index, int sum) {
			if (index == nums.length && sum == 0) {
				return true;
			}

			if (index == nums.length) return false;

			return dfs(nums, index + 1, sum + nums[index]) ||
				dfs(nums, index + 1, sum - nums[index]);
		}
	}

}
//198.打家劫舍
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划

package com.tiger.leetcode.editor.cn;

public class HouseRobber {
	public static void main(String[] args) {
		Solution solution = new HouseRobber().new Solution();
		System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-06-06 20:08:41
	//执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public int rob(int[] nums) {
			if (nums == null || nums.length <= 0) return 0;
			int n = nums.length;

			if (n == 1) return nums[0];

			int lastMax = nums[n - 1];
			int curMax = Math.max(nums[n - 2] + 0, lastMax);

			for (int i = n - 3; i >= 0; i--) {
				int tmp = curMax;
				curMax = Math.max(nums[i] + lastMax, curMax);
				lastMax = tmp;
			}
			return curMax;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)


	class SolutionV2 {
		public int rob(int[] nums) {
			if (nums == null || nums.length == 0) return 0;

			int n = nums.length;
			//dp[i]表示偷或不偷nums[i]，以及之后的房屋，最大金额
			int dp[] = new int[n + 1];

			dp[n - 1] = nums[n - 1];

			for (int i = n - 2; i >= 0; i--) {
				dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
			}
			return dp[0];
		}
	}

	//Date:2020-06-05 22:36:02
	//执行耗时:0 ms,击败了100.00% 的Java用户
	class SolutionV1 {
		public int rob(int[] nums) {
			if (nums == null || nums.length == 0) return 0;
			int n = nums.length;
			int dp[] = new int[n + 2];
			dp[n - 1] = nums[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				dp[i] = Math.max(nums[i] + dp[i + 2], nums[i + 1] + dp[i + 3]);
			}
			return dp[0];
		}
	}

}
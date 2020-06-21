//剑指 Offer 42.连续子数组的最大和
//输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划

package com.tiger.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
	public static void main(String[] args) {
		Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-21 11:57:32
	//执行耗时:1 ms,击败了99.05% 的Java用户
	class Solution {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0) return 0;

			int max = nums[0];
			int cur = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (cur <= 0) {
					cur = nums[i];
				} else {
					cur += nums[i];
				}
				max = Math.max(cur, max);
			}
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-21 11:46:26
	//解答成功: 执行耗时:1 ms,击败了99.05% 的Java用户
	//DP
	class SolutionV1 {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0) return 0;

			int[] dp = new int[nums.length];

			dp[0] = nums[0];
			int max = dp[0];
			for (int i = 1; i < nums.length; i++) {
				dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
				max = Math.max(max, dp[i]);
			}
			return max;
		}
	}

}
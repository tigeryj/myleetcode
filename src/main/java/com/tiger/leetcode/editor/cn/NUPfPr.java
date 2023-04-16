// [剑指 Offer II 101] 分割等和子集
//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
//
// Related Topics 数学 字符串 模拟 👍 80 👎 0


package com.tiger.leetcode.editor.cn;

public class NUPfPr {
    public static void main(String[] args) {
        Solution solution = new NUPfPr().new Solution();
        System.out.println(solution.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 基于V2版本优化
     */
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if ((sum & 1) == 1) return false;
            sum = sum / 2;

            boolean[] dp = new boolean[sum + 1];

            for (int i = 0; i < nums.length; i++) {
                for (int j = sum; j >= 0; j--) {
                    if (i == 0) {
                        if (j == nums[0]) {
                            dp[j] = true;
                        }
                    } else {
                        dp[j] |= j > nums[i] && dp[j - nums[i]];
                    }
                }
            }
            return dp[sum];
        }
    }

    /**
     * dp版本
     */
    class SolutionV2 {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if ((sum & 1) == 1) return false;
            sum = sum / 2;

            boolean[][] dp = new boolean[nums.length][sum + 1];

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (i == 0) {
                        if (j == nums[0]) {
                            dp[i][j] = true;
                        }
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        if (j >= nums[i]) {
                            dp[i][j] |= dp[i - 1][j - nums[i]];
                        }
                    }
                }
            }
            return dp[nums.length - 1][sum];
        }
    }


    /**
     * 记忆化搜索
     */
    class SolutionV1 {
        Boolean[][] memo;

        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if ((sum & 1) == 1) return false;
            sum = sum / 2;

            memo = new Boolean[nums.length][sum + 1];

            return dfs(nums, 0, sum);
        }

        private boolean dfs(int[] nums, int i, int target) {
            if (i == nums.length) return false;
            if (target == 0) return true;

            if (memo[i][target] != null) {
                return memo[i][target];
            }

            boolean res = dfs(nums, i + 1, target) || (target >= nums[i] && dfs(nums, i + 1, target - nums[i]));

            memo[i][target] = res;
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}

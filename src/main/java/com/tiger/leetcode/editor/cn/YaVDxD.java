// [剑指 Offer II 102] 加减的目标值
//给定一个正整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// 
//
// 
// 注意：本题与主站 494 题相同： https://leetcode-cn.com/problems/target-sum/ 
//
// Related Topics 数组 动态规划 回溯 👍 49 👎 0


package com.tiger.leetcode.editor.cn;

public class YaVDxD {
    public static void main(String[] args) {
        Solution solution = new YaVDxD().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // 定义正数和为p，则负数和为sum-p
            // p - sum + p = target ---> p = (sum+target)/2
            // 问题转化为求nums中的子数组和为p的个数
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if (sum + target < 0 || ((sum + target) & 1) != 0) return 0;
            int P = sum + target >> 1;
            int[][] dp = new int[nums.length + 1][P + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j <= P; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - nums[i - 1] >= 0) {
                        dp[i][j] += dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][P];
        }
    }

    class SolutionV1 {
        public int findTargetSumWays(int[] nums, int target) {
            if (nums == null || nums.length == 0) return 0;

            int OFFSET = 1000;
            int[][] dp = new int[nums.length + 1][2001];

            dp[0][0 + OFFSET] = 1;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = -1000; j <= 1000; j++) {
                    if (j + nums[i - 1] <= 1000) {
                        dp[i][j + OFFSET] += dp[i - 1][j + OFFSET + nums[i - 1]];
                    }
                    if (j - nums[i - 1] >= -1000) {
                        dp[i][j + OFFSET] += dp[i - 1][j + OFFSET - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][target + OFFSET];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}

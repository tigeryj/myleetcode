// [剑指 Offer II 089] 房屋偷盗
//一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被
//小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：nums = [2,7,9,3,1]
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
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// 
//
// 
// 注意：本题与主站 198 题相同： https://leetcode-cn.com/problems/house-robber/ 
//
// Related Topics 数组 动态规划 👍 36 👎 0


package com.tiger.leetcode.editor.cn;

public class Gu0c2T {
    public static void main(String[] args) {
        Solution solution = new Gu0c2T().new Solution();
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // https://leetcode.cn/problems/Gu0c2T/solutions/1412201/fang-wu-tou-dao-by-leetcode-solution-885t/
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            // dp[i] 代表 nums[0]~nums[i]，小偷偷到的最大值
            // 分两种情况，偷nums[i]和不偷nums[i], dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1])
            int n = nums.length;
            int[] dp = new int[n + 2];
            for (int i = 2; i < n + 2; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
            }

            return dp[n + 1];
        }
    }

    class SolutionV2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            // f[i] 代表选nums[i - 1]的最大值
            int[] f = new int[n + 1];
            // g[i] 代表不选nums[i - 1]的最大值
            int[] g = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                f[i] = g[i - 1] + nums[i - 1];
                g[i] = Math.max(f[i - 1], g[i - 1]);
            }
            return Math.max(f[n], g[n]);
        }
    }


    class SolutionV1 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            // dp[i]代表偷nums[i]的最大值
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i <= 1) {
                    dp[i] = nums[i];
                } else if (i == 2) {
                    dp[i] = nums[0] + nums[2];
                } else {
                    dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
                }
            }
            return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}

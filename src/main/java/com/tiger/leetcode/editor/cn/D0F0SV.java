// [剑指 Offer II 104] 排列的数目
//给定一个由 不同 正整数组成的数组 nums ，和一个目标整数 target 。请从 nums 中找出并返回总和为 target 的元素组合的个数。数组中的
//数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// 
//
// 
// 注意：本题与主站 377 题相同：https://leetcode-cn.com/problems/combination-sum-iv/ 
//
// Related Topics 数组 动态规划 👍 60 👎 0


package com.tiger.leetcode.editor.cn;

public class D0F0SV {
    public static void main(String[] args) {
        Solution solution = new D0F0SV().new Solution();
        System.out.println(solution.combinationSum4(new int[]{1,2,3}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            if (nums == null || nums.length == 0 || target <= 0) return 0;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int n : nums) {
                    if (i >= n) {
                        dp[i] += dp[i - n];
                    }
                }
            }
            return dp[target];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

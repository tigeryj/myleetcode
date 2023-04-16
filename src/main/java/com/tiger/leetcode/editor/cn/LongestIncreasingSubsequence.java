//300.最长上升子序列
//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package com.tiger.leetcode.editor.cn;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = solution.lengthOfLIS(arr);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            // tails[i] 代表长度为(i+1)的递增子串的最后一个元素的最小值
            int[] tails = new int[nums.length];
            tails[0] = nums[0];
            int end = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > tails[end]) {
                    tails[++end] = nums[i];
                } else {
                    // 1,3,5,7.   4
                    int l = 0, r = end;
                    while (l <= r) {
                        int mid = l + (r - l) / 2;
                        if (tails[mid] < nums[i]) {
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    tails[l] = nums[i];
                }
            }
            return end + 1;
        }
    }

    /**
     * 动态规划
     */
    class SolutionV1 {
        public int lengthOfLIS(int[] nums) {

            if (nums == null || nums.length < 1) return 0;

            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
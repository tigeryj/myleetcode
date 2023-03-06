// [剑指 Offer II 008] 和大于等于 target 的最短子数组
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// 
//
// 
// 注意：本题与主站 209 题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/ 
//
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 102 👎 0


package com.tiger.leetcode.editor.cn;

public class TwoVG8Kg {
    public static void main(String[] args) {
        Solution solution = new TwoVG8Kg().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针法:核心思路，当遍历指针i向右移动时，找到满足条件的j，j也只有向右移动，符合单调性
         *
         */
        public int minSubArrayLen(int target, int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int sum = 0, res = Integer.MAX_VALUE;
            for (int i = 0, j = 0; i < nums.length; i++) {
                sum += nums[i];
                while (j < i && sum - nums[j] >= target) {
                    sum -= nums[j++];
                }
                if (sum >= target) {
                    res = Math.min(res, i - j + 1);
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

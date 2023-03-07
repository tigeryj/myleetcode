// [剑指 Offer II 009] 乘积小于 K 的子数组
//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// 
//
// 
// 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-
//k/ 
//
// Related Topics 数组 滑动窗口 👍 124 👎 0


package com.tiger.leetcode.editor.cn;

public class ZVAVXX {
    public static void main(String[] args) {
        Solution solution = new ZVAVXX().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 经典的双指针法：
         * 关键思路:怎么罗列出所有的子数组?比如指针 [j,i]区间内的乘积小于k,则以i位右边界的子数组都符合条件，有(i-j+1)个，
         * 然后i继续向右遍历，这个时候j也只能向右遍历，使得乘积和重新符合条件
         */
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int m = 1, res = 0;
            for (int i = 0, j = 0; i < nums.length; i++) {
                m *= nums[i];
                while (j < i && m >= k) {
                    m /= nums[j++];
                }
                if (m < k) {
                    res += i - j + 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

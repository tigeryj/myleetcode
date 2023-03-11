// [剑指 Offer II 011] 0 和 1 个数相同的子数组
//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2： 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
//
// Related Topics 数组 哈希表 前缀和 👍 125 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class A1NYOS {
    public static void main(String[] args) {
        Solution solution = new A1NYOS().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 基于前缀和的思路可以优化，没有必要开辟额外的数组空间
         * @param nums
         * @return
         */
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            int counter = 0, res = 0;
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    counter--;
                } else {
                    counter++;
                }
                if (map.containsKey(counter)) {
                    res = Math.max(res, i - map.get(counter));
                } else {
                    map.put(counter, i);
                }
            }
            return res;
        }

        /**
         * 前缀和思路
         * @param nums
         * @return
         */
        public int findMaxLengthV1(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) nums[i] = -1;
            }
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i < nums.length + 1; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            // [i,j] 和为0，则就是sum[j + 1] - sum[i+1] = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            map.put(0, 0);
            for (int i = 1; i < sum.length; i++) {
                if (map.containsKey(sum[i])) {
                    res = Math.max(res, i - map.get(sum[i]));
                } else {
                    map.put(sum[i], i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

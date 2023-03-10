// [剑指 Offer II 010] 和为 k 的子数组
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2： 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
//
// Related Topics 数组 哈希表 前缀和 👍 137 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class QTMn0o {
    public static void main(String[] args) {
        Solution solution = new QTMn0o().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;

            // 求前缀和
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            // 求以i位结尾，且满足s[i]-s[j]=k的j的个数，即 s[j]= s[i]-k，即在区间[0,i)中s[j]=s[i]-k的个数
            int res = 0;
            // map的key代表sum[i],value代表sum[i]出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            map.put(sum[0], 1);
            for (int i = 1; i < sum.length; i++) {
                Integer freq = map.getOrDefault(sum[i] - k, 0);
                res += freq;
                map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

// [剑指 Offer II 004] 只出现一次的数字 
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,100]
//输出：100
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 
//
// 
// 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/ 
//
// Related Topics 位运算 数组 👍 123 👎 0


package com.tiger.leetcode.editor.cn;

public class WGki4K {
    public static void main(String[] args) {
        Solution solution = new WGki4K().new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 核心思路：一个数出现3次，则将所有数的每一位求和，再mod 3 一定是0，如果是1，则就是所要求的那个数的二进制位是1
         */
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) throw new IllegalArgumentException();
            int res = 0;
            for (int i = 0; i <= 31; i++) {
                int sum = 0;
                for (int n : nums) {
                    sum += (n >> i) & 1;
                }
                sum = sum % 3;
                res += (sum << i);
            }
            return res;
        }
    }

    class SolutionV0 {
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) throw new IllegalArgumentException("参数异常");
            int[] counts = new int[32];

            // 所有位求和
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    counts[i] += num & 1;
                    num = num >> 1;
                }
            }
            // 每一位mod 3，结果就是多余的数所对应的二进制位
            int[] resBinary = new int[32];
            for (int i = 0; i < counts.length; i++) {
                resBinary[i] = counts[i] % 3;
            }

            // 根据二进制位求10进制数
            int res = 0;
            for (int i = 0; i < resBinary.length; i++) {
                int part = resBinary[i] << i;
                res += part;
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

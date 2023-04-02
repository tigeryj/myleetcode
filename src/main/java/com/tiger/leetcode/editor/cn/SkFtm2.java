// [剑指 Offer II 070] 排序数组中只出现一次的数字
//给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 
// 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-
//array/ 
//
// Related Topics 数组 二分查找 👍 61 👎 0


package com.tiger.leetcode.editor.cn;

public class SkFtm2 {
    public static void main(String[] args) {
        Solution solution = new SkFtm2().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 1 1 3 4 4
    // 1 1 2 2 3
    // 1 2 2 3 3
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                // 保证mid为偶数
                mid -= mid & 1;
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 2;
                } else {
                    r = mid;
                }
            }
            return nums[l];
        }
    }

    /**
     * 异或运算
     */
    class SolutionV1 {
        public int singleNonDuplicate(int[] nums) {
            int res = 0;
            for (int n : nums) {
                res ^= n;
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}

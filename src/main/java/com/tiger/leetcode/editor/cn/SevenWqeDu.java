// [剑指 Offer II 057] 值和下标之差都在给定的范围内
//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
//
// 
//
// 
// 注意：本题与主站 220 题相同： https://leetcode-cn.com/problems/contains-duplicate-iii/ 
//
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 75 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.TreeSet;

public class SevenWqeDu {
    public static void main(String[] args) {
        Solution solution = new SevenWqeDu().new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{2147483640,2147483641}, 1, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 遍历指针i，向右滑动时，维护左边长度为k的窗口，在这个窗口内寻找到  nums[i]-t <= nums[j] <= nums[i]+t
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Long> treeSet = new TreeSet<>();
            for (int i = 0, j = 0; i < nums.length; i++) {
                Long ceiling = treeSet.ceiling((long) nums[i] - t);
                if (ceiling != null && ceiling <= (long)nums[i] + t) {
                    return true;
                }
                treeSet.add((long) nums[i]);

                // treeSet里只维护k个元素, 所以一旦set里一旦超过k个元素时就要减去一个元素。
                // 即当 i-j+1 > k时删去j元素
                if (i - j + 1 > k) {
                    treeSet.remove((long) nums[j++]);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

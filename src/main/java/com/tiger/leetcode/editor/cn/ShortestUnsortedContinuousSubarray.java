//581.最短无序连续子数组
//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组

package com.tiger.leetcode.editor.cn;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        int unsortedSubarray = solution.findUnsortedSubarray(arr);
        System.out.println(unsortedSubarray);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //主要思想是找到逆序数字索引的最大值和最小值
        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length < 1) return 0;

            int n = nums.length;
            int min = nums[n - 1], max = nums[0];
            int left = -1, right = -2;
            for (int i = 1; i < n; i++) {

                if (nums[i] < max) {
                    right = i;
                } else {
                    max = nums[i];
                }

                if (nums[n - i - 1] > min) {
                    left = n - i - 1;
                } else {
                    min = nums[n - i - 1];
                }
            }
            return right - left + 1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int minIndex = -1, maxIndex = -1;

        int minValue = nums[nums.length - 1];
        int maxValue = nums[0];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > minValue) {
                minIndex = i;
            } else {
                minValue = nums[i];
            }
        }
        if (minIndex == -1) return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < maxValue) {
                maxIndex = i;
            } else {
                maxValue = nums[i];
            }
        }
        return maxIndex - minIndex + 1;
    }
}
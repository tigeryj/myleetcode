//18.四数之和
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] arr = {0, 0, 0, 0};
        List<List<Integer>> lists = solution.fourSum(arr, 1);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return kSum(nums, 4, 0, target);
        }

        private List<List<Integer>> kSum(int[] nums, int k, int start, int target) {
            List<List<Integer>> res = new LinkedList<>();
            if (k == 2) {
                int l = start, r = nums.length - 1;
                while (l < r) {
                    List<Integer> path = new LinkedList<>();
                    if (target - nums[l] == nums[r]) {
                        path.add(nums[l]);
                        path.add(nums[r]);
                        res.add(path);
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
                return res;
            } else {
                for (int i = start; i < nums.length - (k - 1); i++) {

                    if (i > start && nums[i] == nums[i - 1]) continue;

                    List<List<Integer>> tmp = kSum(nums, k - 1, i + 1, target - nums[i]);

                    for (List<Integer> t : tmp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(tmp);
                }
                return res;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
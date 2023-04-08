// [剑指 Offer II 084] 含有重复元素集合的全排列 
//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
//
// Related Topics 数组 回溯 👍 45 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited;
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null || nums.length == 0) return res;
            visited = new boolean[nums.length];
            Arrays.sort(nums);
            backTracking(nums, new ArrayList<>());
            return res;
        }

        private void backTracking(int[] nums, List<Integer> path) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                path.add(nums[i]);
                backTracking(nums, path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

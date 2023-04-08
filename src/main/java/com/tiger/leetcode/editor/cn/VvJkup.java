// [剑指 Offer II 083] 没有重复元素集合的全排列
//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
//
// Related Topics 数组 回溯 👍 50 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class VvJkup {
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) return res;
            visited = new boolean[nums.length];
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

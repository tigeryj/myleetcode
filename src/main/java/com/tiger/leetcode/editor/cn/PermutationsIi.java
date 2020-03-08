//47:全排列 II
//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution
    {
        public List<List<Integer>> permuteUnique(int[] nums)
        {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            boolean[] visited = new boolean[nums.length];
            backTracking(nums, res, visited, new ArrayList<Integer>());

            return res;
        }

        private void backTracking(int[] nums, List<List<Integer>> res, boolean[] visited,
                                  ArrayList<Integer> path)
        {
            if (path.size() == nums.length)
            {
                res.add(new ArrayList<Integer>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++)
            {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                    continue;
                if (visited[i])
                    continue;

                path.add(nums[i]);
                visited[i] = true;

                backTracking(nums, res, visited, path);

                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
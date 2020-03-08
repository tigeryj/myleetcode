//46:全排列
//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            boolean[] visited = new boolean[nums.length];

            List<List<Integer>> res = new ArrayList();
            backTracking(nums, res, new ArrayList<Integer>(), visited);
            return res;
        }

        private void backTracking(int[] nums, List<List<Integer>> res, ArrayList<Integer> path,
                                  boolean[] visited) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<Integer>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }

                path.add(nums[i]);
                visited[i] = true;
                backTracking(nums, res, path, visited);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
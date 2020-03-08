//216:组合总和 III
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        List<List<Integer>> lists = solution.combinationSum3(2, 18);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {

            List<List<Integer>> res = new ArrayList<>();

            backTracking(res, new ArrayList<>(), n, 1, k);

            return res;
        }

        private void backTracking(List<List<Integer>> res, List<Integer> path, int target, int start, int k) {
            if (path.size() == k && target == 0) {
                res.add(new ArrayList<>(path));
                return;
            } else if (path.size() == k || target <= 0) {
                return;
            }

            for (int i = start; i <= 9 && i <= target; i++) {
                path.add(i);
                backTracking(res, path, target - i, i + 1, k);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
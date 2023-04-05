// [剑指 Offer II 080] 含有 k 个元素的组合
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
//
// Related Topics 数组 回溯 👍 46 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class UUsW3B {
    public static void main(String[] args) {
        Solution solution = new UUsW3B().new Solution();
        solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (n < 1 || k < 1) return res;
            backTrack(n, 1, k, new ArrayList<>());
            return res;
        }

        private void backTrack(int n, int start, int k, List<Integer> path) {
            if (k == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i <= n; i++) {
                path.add(i);
                backTrack(n, i + 1, k - 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

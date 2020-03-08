//77:组合
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();

        solution.combine(4, 2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int n;
        private int k;
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backTrace(1, new LinkedList<>());
            return res;
        }

        private void backTrace(int start, List<Integer> path) {

            if (path.size() == k) {
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = start; i <= n - k + path.size() + 1; i++) {
                path.add(i);
                backTrace(i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
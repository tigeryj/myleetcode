//22:括号生成
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();

            backTrace(res, "", 0, 0, n);
            return res;
        }

        private void backTrace(List<String> res, String path, int l, int r, int n) {

            if (l == n && r == n) {
                res.add(path);
                return;
            }

            if (l < r) {
                return;
            }

            if (l < n) {
                backTrace(res, path + "(", l + 1, r, n);
            }

            if (r < n) {
                backTrace(res, path + ")", l, r + 1, n);
            }

        }


        //待优化
        private void backTracking(List<String> res, String path, int n, int balance, int lCount) {

            if (path.length() == 2 * n) {
                res.add(path);
                return;
            } else if (balance < 0) {
                return;
            }
            if (lCount < n) {
                backTracking(res, path + "(", n, balance + 1, lCount + 1);
            }
            backTracking(res, path + ")", n, balance - 1, lCount);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
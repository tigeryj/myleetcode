// [剑指 Offer II 085] 生成匹配的括号
//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 
//
// 
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
//
// Related Topics 字符串 动态规划 回溯 👍 69 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IDBivT {
    public static void main(String[] args) {
        Solution solution = new IDBivT().new Solution();
        System.out.println(solution.generateParenthesis(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars = new char[]{'(', ')'};
        List<String> res = new ArrayList<>();
        int[] freq = new int[2];

        public List<String> generateParenthesis(int n) {
            backTracking(n, new StringBuilder());
            return res;

        }

        private void backTracking(int n, StringBuilder sb) {
            if (freq[0] == n && freq[1] == n) {
                res.add(sb.toString());
                return;
            }
            if (freq[0] > n || freq[1] > n || freq[0] < freq[1]) return;

            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
                freq[i]++;
                backTracking(n, sb);
                freq[i]--;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

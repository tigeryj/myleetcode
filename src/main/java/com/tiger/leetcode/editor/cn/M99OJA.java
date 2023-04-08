// [剑指 Offer II 086] 分割回文子字符串
//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
//
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 55 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class M99OJA {
    public static void main(String[] args) {
        Solution solution = new M99OJA().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp;

        public String[][] partition(String s) {
            if (s == null || s.length() == 0) return new String[0][0];
            dp = new boolean[s.length()][s.length()];
            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (j - i < 2) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    }
                }
            }

            backTracking(s, 0, new ArrayList<>());
            String[][] r = new String[res.size()][];
            for (int i = 0; i < r.length; i++) {
                r[i] = new String[res.get(i).size()];
                for (int j = 0; j < r[i].length; j++) {
                    r[i][j] = res.get(i).get(j);
                }
            }
            return r;
        }

        private void backTracking(String s, int start, List<String> path) {
            if (start == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (dp[start][i]) {
                    path.add(s.substring(start, i + 1));
                    backTracking(s, i + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isValid(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) return false;
                l++;
                r--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

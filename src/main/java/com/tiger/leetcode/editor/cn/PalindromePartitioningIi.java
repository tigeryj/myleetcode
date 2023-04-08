// [132] 分割回文串 II
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 659 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Arrays;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        System.out.println(solution.minCut("aab"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] dp;

        public int minCut(String s) {
            if (s == null || s.length() == 0) return 0;
            dp = new boolean[s.length()][s.length()];
            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (j - i < 2) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    }
                }
            }
            int[] r = new int[s.length()];
            Arrays.fill(r, Integer.MAX_VALUE);
            // r[i]代表以i结尾的最小的分割数
            // r[i] = Min(r[k] + 1), 0=<k<i

            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (dp[i][j]) {
                        if (i == 0) {
                            r[j] = 1;
                        } else {
                            r[j] = Math.min(r[j], r[i - 1] + 1);
                        }
                    }
                }
            }
            return r[s.length() - 1] - 1;

        }

//        private void backTracking(String s, int start, int count) {
//            if (start == s.length()) {
//                res = Math.min(res, count - 1);
//            }
//            for (int i = s.length() - 1; i >= start; i--) {
//                if (dp[start][i]) {
//                    backTracking(s, i + 1, count + 1);
//                    break;
//                }
//            }
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

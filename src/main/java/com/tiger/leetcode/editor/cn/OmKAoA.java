// [剑指 Offer II 094] 最少回文分割
//给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。 
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
// 
//
// 
// 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-
//ii/ 
//
// Related Topics 字符串 动态规划 👍 62 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Arrays;

public class OmKAoA {
    public static void main(String[] args) {
        Solution solution = new OmKAoA().new Solution();
        System.out.println(solution.minCut("cdd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            if (s == null || s.length() == 0) return 0;
            int n = s.length();

            // f[i][j]表示i~j是否是回文串，f[i][j] = f[i+1][j-1] && s[i] == s[j]
            boolean[][] f = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i <= j; i++) {
                    if (j - i < 2) {
                        f[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    }
                }
            }

            // dp[i] 代表以i为结尾的最少分割次数
            // dp[i] = min{dp[k]} + 1 k满足s[k+1]~s[i]是回文串
            int[] dp = new int[n];
            Arrays.fill(dp, n - 1);
            dp[0] = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i <= j; i++) {
                    if (f[i][j]) {
                        if (i == 0) {
                            dp[j] = 0;
                            break;
                        } else {
                            dp[j] = Math.min(dp[j], dp[i - 1] + 1);
                        }
                    }
                }
            }
            return dp[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

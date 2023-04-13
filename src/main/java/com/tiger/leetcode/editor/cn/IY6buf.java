// [剑指 Offer II 096] 字符串交织
//给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。 
//
// 两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 97 题相同： https://leetcode-cn.com/problems/interleaving-string/ 
//
// Related Topics 字符串 动态规划 👍 57 👎 0


package com.tiger.leetcode.editor.cn;

public class IY6buf {
    public static void main(String[] args) {
        Solution solution = new IY6buf().new Solution();
        System.out.println(solution.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;
            // dp[i][j]代表能不能s1的前i个元素和s2的前j个元素能不能组合成s3的前i+j+1个元素
            // dp[i][j]和dp[i-1][j]和dp[i][j-1]有关系

            int m = s1.length();
            int n = s2.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
            }


            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int p = i + j - 1;
                    if (s1.charAt(i - 1) == s3.charAt(p)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (s2.charAt(j - 1) == s3.charAt(p)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

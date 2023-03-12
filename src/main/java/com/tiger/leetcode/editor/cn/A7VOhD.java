// [剑指 Offer II 020] 回文子字符串的个数
//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
//
// Related Topics 字符串 动态规划 👍 82 👎 0


package com.tiger.leetcode.editor.cn;

public class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         * @param s
         * @return
         */
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) return 0;
            int res = 0;
            // dp[i][j] 代表[i,j]区间的字串是不是回文
            // dp[i][j] = s[i] == s[j] && dp[i+1][j-1],i+1<j-1 ==> j-i>2
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int j = 0; j < s.length(); j++) {
                for (int i = j; i >= 0; i--) {
                    if (j - i < 3) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        res++;
                    }
                }
            }
            return res;
        }

        /**
         * 中心点扩散法
         * 核心思路：遍历指针i从左向右移动
         * 当以i为中心向两边扩散，计算有多少个回文子串
         * 注意：以i为中心分两种情况，字串长度是偶数或奇数
         *
         * @param s
         * @return
         */
        public int countSubstringsV1(String s) {
            if (s == null || s.length() == 0) return 0;
            char[] chars = s.toCharArray();
            int res = 0;
            for (int i = 0; i < chars.length; i++) {
                // 枚举以i为中心的奇数串
                for (int j = i, k = i; j < chars.length && k >= 0; j++, k--) {
                    if (chars[j] != chars[k]) break;
                    res++;
                }
                // 枚举以i,i+1为中心的偶数串
                for (int j = i + 1, k = i; j < chars.length && k >= 0; j++, k--) {
                    if (chars[j] != chars[k]) break;
                    res++;
                }
            }
            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}

//5.最长回文子串
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package com.tiger.leetcode.editor.cn;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		Solution solution = new LongestPalindromicSubstring().new Solution();
		System.out.println(solution.longestPalindrome("babad"));
	}

	//todo 中心扩散法
	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-05-18 10:27:06
	//执行耗时:143 ms,击败了32.28% 的Java用户
	class Solution {
		public String longestPalindrome(String s) {
			if (s == null || s.isEmpty()) return s;

			boolean[][] dp = new boolean[s.length()][s.length()];

			int maxLen = 1, begin = 0;
			for (int r = 0; r < s.length(); r++) {
				for (int l = 0; l <= r; l++) {

					if (s.charAt(l) == s.charAt(r)) {
						if (r - l < 3) {
							dp[l][r] = true;
						} else {
							dp[l][r] = dp[l + 1][r - 1];
						}
					} else {
						dp[l][r] = false;
					}
					if (dp[l][r]) {
						if (r - l + 1 > maxLen) {
							maxLen = r - l + 1;
							begin = l;
						}
					}
				}
			}
			return s.substring(begin, begin + maxLen);
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	class SolutionV1 {
		public String longestPalindrome(String s) {
			if (s == null || s.isEmpty()) return s;

			boolean[][] dp = new boolean[s.length()][s.length()];

			for (int r = 0; r < s.length(); r++) {
				for (int l = 0; l <= r; l++) {
					if (s.charAt(l) == s.charAt(r) && ((r - l < 3) || dp[l + 1][r - 1])) {
						dp[l][r] = true;
					}
				}
			}

			int maxLen = Integer.MIN_VALUE, l = 0, r = 0;
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j <= i; j++) {
					if (dp[j][i] && i - j + 1 > maxLen) {
						maxLen = i - j + 1;
						l = j;
						r = i;
					}
				}
			}
			return s.substring(l, r + 1);
		}
	}
}
//1143.最长公共子序列
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划

package com.tiger.leetcode.editor.cn;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Solution solution = new LongestCommonSubsequence().new Solution();
		System.out.println(solution.longestCommonSubsequence("bl", "yby"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-14 14:42:59
	//执行耗时:13 ms,击败了73.11% 的Java用户
	class Solution {
		public int longestCommonSubsequence(String text1, String text2) {
			if (text1 == null || text2 == null) return 0;
			int m = text1.length();
			int n = text2.length();
			int[][] dp = new int[m + 1][n + 1];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (text1.charAt(i) == text2.charAt(j)) {
						dp[i + 1][j + 1] = dp[i][j] + 1;
					} else {
						dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
					}
				}
			}
			return dp[m][n];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-14 11:43:35
	//执行耗时:12 ms,击败了76.85% 的Java用户
	class SolutionV1 {
		public int longestCommonSubsequence(String text1, String text2) {
			if (text1 == null || text2 == null) return 0;
			int m = text1.length();
			int n = text2.length();
			int[][] dp = new int[m][n];

			for (int j = 0; j < n; j++) {
				if (text2.charAt(j) == text1.charAt(0)) {
					dp[0][j] = 1;
				} else {
					dp[0][j] = j == 0 ? 0 : dp[0][j - 1];
				}
			}

			for (int i = 0; i < m; i++) {
				if (text1.charAt(i) == text2.charAt(0)) {
					dp[i][0] = 1;
				} else {
					dp[i][0] = i == 0 ? 0 : dp[i - 1][0];
				}
			}

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (text1.charAt(i) == text2.charAt(j)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
			return dp[m - 1][n - 1];
		}
	}

}
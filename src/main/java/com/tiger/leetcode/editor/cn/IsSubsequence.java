//392.判断子序列
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
//？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划

package com.tiger.leetcode.editor.cn;

public class IsSubsequence {
	public static void main(String[] args) {
		Solution solution = new IsSubsequence().new Solution();
		System.out.println(solution.isSubsequence("abc", "ahbgdc"));
		System.out.println(solution.isSubsequence("axc", "ahbgdc"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)


	//Date:2020-06-14 15:36:22
	//执行耗时:2 ms,击败了65.51% 的Java用
	//贪心
	class Solution {
		public boolean isSubsequence(String s, String t) {
			if (s == null || t == null) return false;

			int i = 0, j = 0;

			while (i < s.length() && j < t.length()) {
				if (s.charAt(i) == t.charAt(j++)) i++;
			}

			return i == s.length();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-14 15:29:53
	//执行耗时:5 ms,击败了49.19% 的Java用户
	//DP
	class SolutionV1 {
		public boolean isSubsequence(String s, String t) {
			if (s == null || t == null) return false;

			int m = s.length(), n = t.length();
			boolean dp[][] = new boolean[m + 1][n + 1];
			for (int j = 0; j < n + 1; j++) {
				dp[0][j] = true;
			}

			for (int i = 1; i < m + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (s.charAt(i - 1) == t.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}

			return dp[m][n];
		}
	}

}
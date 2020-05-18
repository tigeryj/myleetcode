//131.分割回文串
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		Solution solution = new PalindromePartitioning().new Solution();
		List<List<String>> res = solution.partition("aab");
		System.out.println(res.toString());
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public List<List<String>> partition(String s) {
			List<List<String>> res = new ArrayList<>();
			if (s == null || s.isEmpty()) return res;

			boolean[][] dp = new boolean[s.length()][s.length()];
			for (int r = 0; r < s.length(); r++) {
				for (int l = 0; l <= r; l++) {
					if (s.charAt(l) == s.charAt(r) && ((r - l < 2) || dp[l + 1][r - 1])) {
						dp[l][r] = true;
					}
				}
			}

			List<String> path = new LinkedList<>();

			backTracking(s, 0, path, res, dp);

			return res;
		}

		private void backTracking(String s, int begin, List<String> path, List<List<String>> res, boolean[][] dp) {
			if (begin == s.length()) {
				res.add(new ArrayList<>(path));
				return;
			}
			for (int end = begin + 1; end <= s.length(); end++) {
				String sub = s.substring(begin, end);
				if (dp[begin][end - 1]) {
					path.add(sub);
					backTracking(s, end, path, res, dp);
					path.remove(path.size() - 1);
				}
			}
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)
	class SolutionV1 {

		public List<List<String>> partition(String s) {
			List<List<String>> res = new ArrayList<>();
			if (s == null || s.isEmpty()) return res;

			List<String> path = new LinkedList<>();

			backTracking(s, 0, path, res);

			return res;
		}

		private void backTracking(String s, int begin, List<String> path, List<List<String>> res) {
			if (begin == s.length()) {
				res.add(new ArrayList<>(path));
				return;
			}
			for (int end = begin + 1; end <= s.length(); end++) {
				String sub = s.substring(begin, end);
				if (isPalindrome(sub)) {
					path.add(sub);
					backTracking(s, end, path, res);
					path.remove(path.size() - 1);
				}
			}
		}

		private boolean isPalindrome(String str) {
			if (str == null || str.isEmpty()) return false;

			int l = 0, r = str.length() - 1;

			while (l < r) {
				if (str.charAt(l++) != str.charAt(r--)) {
					return false;
				}
			}
			return true;
		}
	}

}
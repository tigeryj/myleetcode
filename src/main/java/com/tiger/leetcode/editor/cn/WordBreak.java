//139.单词拆分
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		Solution solution = new WordBreak().new Solution();
		System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
	}

	class Solution {
		public boolean wordBreak(String s, List<String> wordDict) {
			if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;

			// dp[i]代表以s中0～i的字符串是否被wordDict组合
			boolean[] dp = new boolean[s.length() + 1];
			dp[0] = true;
			for (int j = 1; j <= s.length(); j++) {
				for (String w : wordDict) {
					if (j >= w.length() && w.equals(s.substring(j - w.length(), j))) {
						dp[j] |= dp[j - w.length()];
					}
				}
			}
			return dp[s.length()];
		}
	}

	class SolutionV2 {
		public boolean wordBreak(String s, List<String> wordDict) {
			if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) return false;

			//dp[i]表示s中第1-i个元素是否可以用wordDict去表示
			boolean[] dp = new boolean[s.length()];

			for (int i = 0; i < s.length(); i++) {
				dp[i] = wordDict.contains(s.substring(0, i + 1));
				for (int j = 1; j <= i; j++) {
					if (dp[i]) break;
					dp[i] |= dp[i - j] && wordDict.contains(s.substring(i - j + 1, i + 1));
				}
			}
			return dp[s.length() - 1];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	class SolutionV1 {
		public boolean wordBreak(String s, List<String> wordDict) {
			if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) return false;

			boolean[] dp = new boolean[s.length() + 1];
			Set<String> dict = new HashSet<>(wordDict);
			dp[0] = true;

			for (int i = 1; i <= s.length(); i++) {
				for (int j = 0; j < i; j++) {
					dp[i] |= dp[j] && dict.contains(s.substring(j, i));
					if (dp[i]) break;
				}
			}
			return dp[s.length()];
		}
	}

}
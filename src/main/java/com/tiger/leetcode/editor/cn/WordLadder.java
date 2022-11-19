//127.单词接龙
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索

package com.tiger.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {
	public static void main(String[] args) {
		Solution solution = new WordLadder().new Solution();
		List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		int i = solution.ladderLength("hit", "cog", list);
		System.out.println(i);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//todo v2?
		public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			Map<String, List<String>> dic = prepare(wordList);

			Queue<Pair<String, Integer>> queue = new LinkedList<>();
			Set<String> visited = new HashSet<>();
			queue.add(new Pair<>(beginWord, 1));

			while (!queue.isEmpty()) {
				Pair<String, Integer> poll = queue.poll();
				String word = poll.getKey();
				Integer level = poll.getValue();
				List<String> patterns = getPatterns(word);
				for (String pattern : patterns) {
					List<String> similarWords = dic.getOrDefault(pattern, new ArrayList());
					for (String similarWord : similarWords) {
						if (!visited.contains(similarWord)) {
							visited.add(word);
							if (similarWord.equals(endWord)) return level + 1;
							queue.add(new Pair<>(similarWord, level + 1));
						}
					}
				}
			}
			return 0;
		}

		private Map<String, List<String>> prepare(List<String> wordList) {
			Map<String, List<String>> patternDic = new HashMap<>();
			for (String word : wordList) {
				List<String> patterns = getPatterns(word);
				for (String pattern : patterns) {
					List<String> patternWords = patternDic.getOrDefault(pattern, new ArrayList<>());
					patternWords.add(word);
					patternDic.put(pattern, patternWords);
				}
			}
			return patternDic;
		}

		private List<String> getPatterns(String word) {
			List<String> patterns = new LinkedList<>();
			if (word == null || word.isEmpty()) return patterns;
			int len = word.length();
			for (int i = 0; i < len; i++) {
				patterns.add(word.substring(0, i) + "*" + word.substring(i + 1, len));
			}
			return patterns;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
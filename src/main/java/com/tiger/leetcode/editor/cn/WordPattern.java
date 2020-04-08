//290.单词规律
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
	public static void main(String[] args) {
		Solution solution = new WordPattern().new Solution();
		//false
		System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
		//false
		System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
		//true
		System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean wordPattern(String pattern, String str) {
			String[] strs = str.split(" ");
			if (pattern.length() != strs.length) return false;
			Map<Object, Integer> map = new HashMap<>();
			for (Integer i = 0; i < pattern.length(); i++) {
				if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(strs[i], i))) {
					return false;
				}
			}
			return true;
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (pattern.length() != strs.length) return false;

		HashMap<Character, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(strs[i])) return false;
			} else {
				if (set.contains(strs[i])) return false;
				map.put(pattern.charAt(i), strs[i]);
				set.add(strs[i]);
			}
		}
		return true;
	}

}
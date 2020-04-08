//205.同构字符串
//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Objects;

public class IsomorphicStrings {
	public static void main(String[] args) {
		Solution solution = new IsomorphicStrings().new Solution();
		System.out.println(solution.isIsomorphic("aab", "aaa"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isIsomorphic(String s, String t) {
			HashMap<Character, Integer> sMap = new HashMap<>();
			HashMap<Character, Integer> tMap = new HashMap<>();
			if (s.length() != t.length()) return false;
			for (int j = 0; j < s.length(); j++) {
				if (sMap.containsKey(s.charAt(j)) && tMap.containsKey(t.charAt(j))) {
					if (sMap.get(s.charAt(j)).intValue() != tMap.get(t.charAt(j))) return false;
				} else if (sMap.containsKey(s.charAt(j)) || tMap.containsKey(t.charAt(j))) {
					return false;
				} else {
					sMap.put(s.charAt(j), j);
					tMap.put(t.charAt(j), j);
				}
			}
			return true;
		}

		public boolean isIsomorphicV1(String s, String t) {
			HashMap<Character, Integer> sMap = new HashMap<>();
			HashMap<Character, Integer> tMap = new HashMap<>();
			if (s.length() != t.length()) return false;
			int i = 0;
			while (i < s.length()) {

				if (!Objects.equals(sMap.put(s.charAt(i), i),
					tMap.put(t.charAt(i), i))) {
					return false;
				}
				i++;
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
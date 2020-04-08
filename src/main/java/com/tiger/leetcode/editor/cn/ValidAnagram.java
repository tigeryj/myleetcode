//242.有效的字母异位词
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;

public class ValidAnagram {
	public static void main(String[] args) {
		Solution solution = new ValidAnagram().new Solution();
		System.out.println(solution.isAnagram("",""));
		System.out.println(solution.isAnagram("anagram","nagaram"));
		System.out.println(solution.isAnagram("abb","ab"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isAnagram(String s, String t) {
			HashMap<Character, Integer> map = new HashMap<>();
			for (char c : s.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			for (char c : t.toCharArray()) {
				if (!map.containsKey(c)) return false;

				Integer freq = map.get(c);

				if (freq == 1) {
					map.remove(c);
				} else {
					map.put(c, freq - 1);
				}
			}
			return map.isEmpty();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
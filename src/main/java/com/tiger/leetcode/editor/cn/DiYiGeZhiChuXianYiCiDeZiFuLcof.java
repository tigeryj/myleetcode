//剑指 Offer 50.第一个只出现一次的字符
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表

package com.tiger.leetcode.editor.cn;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
	public static void main(String[] args) {
		Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-07-11 22:20:57
	//解答成功: 执行耗时:6 ms,击败了89.38% 的Java用户
	class Solution {
		public char firstUniqChar(String s) {
			if (s == null || s == "") return ' ';
			int[] freq = new int[26];
			for (char c : s.toCharArray()) {
				freq[c - 'a']++;
			}

			for (char c : s.toCharArray()) {
				if (freq[c - 'a'] == 1) {
					return c;
				}
			}
			return ' ';
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
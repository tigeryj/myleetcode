//14.最长公共前缀
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package com.tiger.leetcode.editor.cn;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		Solution solution = new LongestCommonPrefix().new Solution();
	}

	//todo 分治法
	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-16 23:22:57
	//执行耗时:3 ms,击败了23.63% 的Java用户
	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0) return "";

			String res = strs[0];

			for (int i = 1; i < strs.length; i++) {

				for (int j = 0; j < res.length(); j++) {
					if (j >= strs[i].length() || res.charAt(j) != strs[i].charAt(j)) {
						res = res.substring(0, j);
						break;
					}
				}
			}

			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-16 22:57:50
	//解答成功: 执行耗时:1 ms,击败了78.40% 的Java用户
	class SolutionV1 {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0) return "";

			int end = -1;

			for (int i = 0; i < strs[0].length(); i++) {
				char c = strs[0].charAt(i);

				for (int j = 1; j < strs.length; j++) {
					if (i >= strs[j].length() || strs[j].charAt(i) != c) {
						return strs[0].substring(0, end + 1);
					}
				}
				end++;
			}

			return strs[0].substring(0, end + 1);
		}
	}

}
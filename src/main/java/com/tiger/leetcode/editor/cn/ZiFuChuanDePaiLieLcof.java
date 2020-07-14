//剑指 Offer 38.字符串的排列
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
////
////
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ZiFuChuanDePaiLieLcof {
	public static void main(String[] args) {
		Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
		String abc = Arrays.toString(solution.permutation("abc"));
		System.out.println(abc);
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//aabcba

	//Date:2020-07-14 22:43:12
	//解答成功: 执行耗时:23 ms,击败了43.30% 的Java用户
	class Solution {

		boolean[] visited;
		List<String> res = new LinkedList<>();

		public String[] permutation(String s) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			visited = new boolean[chars.length];

			backTracking("", chars);

			return res.toArray(new String[]{});
		}


		private void backTracking(String path, char[] chars) {
			if (path.length() == chars.length) {
				res.add(path);
				return;
			}

			for (int i = 0; i < chars.length; i++) {
				if (visited[i]) continue;
				if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;

				visited[i] = true;

				backTracking(path + chars[i], chars);

				visited[i] = false;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
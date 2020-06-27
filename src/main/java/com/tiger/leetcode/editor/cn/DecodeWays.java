//91.解码方法
//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划

package com.tiger.leetcode.editor.cn;

public class DecodeWays {
	public static void main(String[] args) {
		Solution solution = new DecodeWays().new Solution();
		System.out.println(solution.numDecodings("227"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	class Solution {

		//解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户
		//Date:2020-06-25 21:59:42
		//只考虑1位和2为的情况，遇到dp[i]=0不提前结束，继续往下算
		public int numDecodings(String s) {
			if (s == null || s.length() == 0) return 0;
			int n = s.length();
			char[] chs = s.toCharArray();
			int[] dp = new int[n + 1];

			dp[0] = 1;
			for (int i = 1; i <= n; i++) {
				dp[i] = 0;
				if (chs[i - 1] - '0' > 0) {
					dp[i] += dp[i - 1];
				}

				if (i > 1) {
					int num = (chs[i - 2] - '0') * 10 + chs[i - 1] - '0';
					if (num >= 10 && num <= 26) {
						dp[i] += dp[i - 2];
					}
				}
			}

			return dp[n];

		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-25 18:43:57
	//执行耗时:1 ms,击败了100.00% 的Java用户
	class SolutionV4 {

		//1334321414
		/*
			1->A;
			2->B;
		*/
		public int numDecodings(String s) {
			if (s == null || s.length() == 0) return 0;
			int n = s.length();

			char[] chs = s.toCharArray();

			int[] dp = new int[n + 1];

			if (chs[0] == '0') return 0;
			dp[0] = 1;
			dp[1] = 1;

			for (int i = 2; i <= n; i++) {
				if (chs[i - 1] == '0') {
					if (chs[i - 2] == '1' || chs[i - 2] == '2') {
						dp[i] = dp[i - 2];
					} else {
						return 0;
					}
				} else {
					dp[i] = dp[i - 1];
					if (chs[i - 2] == '1' || chs[i - 2] == '2' && chs[i - 1] < '7') {
						dp[i] += dp[i - 2];
					}
				}
			}
			return dp[n];

		}
	}


	//执行耗时:1 ms,击败了100.00% 的Java用户
	//Date:2020-06-05 21:08:00
	class SolutionV3 {

		//1334321414
		/*
			1->A;
			2->B;
		*/
		public int numDecodings(String s) {
			if (s == null || s.isEmpty()) return 0;

			int dp[] = new int[s.length() + 1];
			dp[s.length()] = 1;
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == '0') continue;

				dp[i] = dp[i + 1];
				if (i + 1 < s.length()) {
					int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
					if (num <= 26) {
						dp[i] += dp[i + 2];
					}
				}
			}
			return dp[0];
		}
	}

	//执行耗时:3 ms,击败了34.85% 的Java用户
	class SolutionV2 {
		Integer dp[];

		public int numDecodings(String s) {
			if (s == null || s.isEmpty()) return 0;
			dp = new Integer[s.length()];
			return dfs(s, 0);
		}

		private int dfs(String s, int start) {

			if (start >= s.length()) return 1;

			if (s.charAt(start) == '0') return 0;

			if (dp[start] != null) return dp[start];

			int res = 0;
			res += dfs(s, start + 1);

			//字符串比较要比转化成数值后再比较慢很多。
			if (start + 1 < s.length() && s.substring(start, start + 2).compareTo("26") <= 0) {
				res += dfs(s, start + 2);
			}
			dp[start] = res;
			return res;
		}
	}

	class SolutionV1 {
		//todo 优化？查看解析
		// https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/

		//执行耗时:1 ms,击败了100.00% 的Java用户
		//Date:2020-06-03 22:20:44
		public int numDecodings(String s) {
			if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

			int n = s.length();
			int[] dp = new int[n + 1];
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 1; i < n; i++) {
				if (s.charAt(i) == '0') {
					if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
						dp[i + 1] = dp[i - 1];
					} else {
						return 0;
					}
				} else {
					dp[i + 1] += dp[i];
					if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
						dp[i + 1] += dp[i - 1];
					}
				}
			}
			return dp[n];
		}
	}
}
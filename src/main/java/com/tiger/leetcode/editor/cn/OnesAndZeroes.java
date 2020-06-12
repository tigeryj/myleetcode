//474.一和零
//在计算机界中，我们总是追求用有限的资源获取最大的收益。 
//
// 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。 
//
// 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。 
//
// 注意: 
//
// 
// 给定 0 和 1 的数量都不会超过 100。 
// 给定字符串数组的长度不会超过 600。 
// 
//
// 示例 1: 
//
// 
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
// 
//
// 示例 2: 
//
// 
//输入: Array = {"10", "0", "1"}, m = 1, n = 1
//输出: 2
//
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
// 
// Related Topics 动态规划

package com.tiger.leetcode.editor.cn;

public class OnesAndZeroes {
	public static void main(String[] args) {
		Solution solution = new OnesAndZeroes().new Solution();
		System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-12 20:35:19
	//执行耗时:31 ms,击败了84.10% 的Java用户
	class Solution {
		public int findMaxForm(String[] strs, int m, int n) {

			//dp[j][k]表示 j个0和k个1凑出的最大数量
			int[][] dp = new int[m + 1][n + 1];

			for (int i = 0; i < strs.length; i++) {
				int[] counts = new int[2];
				for (char c : strs[i].toCharArray()) {
					counts[c - '0']++;
				}

				int zeros = counts[0];
				int ones = counts[1];

				for (int j = m; j >= zeros; j--) {
					for (int k = n; k >= ones; k--) {
						dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
					}
				}

			}

			return dp[m][n];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
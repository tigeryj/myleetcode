//518.零钱兑换 II
//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
//

package com.tiger.leetcode.editor.cn;

public class CoinChange2 {
	public static void main(String[] args) {
		Solution solution = new CoinChange2().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)


	//基于V2空间压缩

	//Date:2020-06-17 21:49:16
	//执行耗时:3 ms,击败了78.79% 的Java用户
	class Solution {
		public int change(int amount, int[] coins) {
			if (amount < 0 || coins == null) return 0;
			int n = coins.length;
			//dp[i] 表示前j个元素组成金额amount总共有几种方法
			int[] dp = new int[amount + 1];
			dp[0] = 1;

			for (int i = 0; i < n; i++) {
				for (int j = coins[i]; j <= amount; j++) {
					dp[j] += dp[j - coins[i]];
				}
			}
			return dp[amount];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-17 21:34:05
	//执行耗时:8 ms,击败了31.50% 的Java用户
	class SolutionV2 {
		public int change(int amount, int[] coins) {
			if (amount < 0 || coins == null) return 0;
			if (amount == 0) return 1;
			if (coins.length == 0) return 0;
			int n = coins.length;
			//dp[i][j] 表示前i个元素组成金额j总共有几种方法
			int[][] dp = new int[n][amount + 1];

			for (int j = 0; j * coins[0] <= amount; j++) {
				dp[0][j * coins[0]] = 1;
			}


			for (int i = 1; i < n; i++) {
				for (int j = 0; j <= amount; j++) {
					dp[i][j] = dp[i - 1][j];
					if (j >= coins[i]) {
						dp[i][j] += dp[i][j - coins[i]];
					}
				}
			}

			return dp[n - 1][amount];
		}
	}


	//Date:2020-06-17 20:46:37
	//执行耗时:40 ms,击败了7.78% 的Java用户
	class SolutionV1 {
		public int change(int amount, int[] coins) {
			if (amount < 0 || coins == null) return 0;
			if (amount == 0) return 1;
			if (coins.length == 0) return 0;
			int n = coins.length;
			//dp[i][j] 表示前i个元素组成金额j总共有几种方法
			int[][] dp = new int[n][amount + 1];

			for (int j = 0; j <= amount; j++) {
				if (j % coins[0] == 0) dp[0][j] = 1;
			}


			for (int i = 1; i < n; i++) {
				for (int j = 0; j <= amount; j++) {
					for (int k = 0; k * coins[i] <= j; k++) {
						dp[i][j] += dp[i - 1][j - k * coins[i]];
					}
				}
			}

			return dp[n - 1][amount];
		}
	}

}
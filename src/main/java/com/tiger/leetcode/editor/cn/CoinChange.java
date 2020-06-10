//322.零钱兑换
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		Solution solution = new CoinChange().new Solution();
//		System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
//		System.out.println(solution.coinChange(new int[]{2}, 3));
//		System.out.println(solution.coinChange(new int[]{2}, 4));
//		System.out.println(solution.coinChange(new int[]{4}, 4));
//		System.out.println(solution.coinChange(new int[]{1}, 0));
		System.out.println(solution.coinChange(new int[]{2, 5, 10, 1}, 27));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-10 23:55:05
	//执行耗时:20 ms,击败了39.31% 的Java用户
	class Solution {
		public int coinChange(int[] coins, int amount) {

			int n = coins.length;

			//dp[amount] 表示凑出amount钱需要的最小数目,比如coins={1,2,5}，amount=11
			//转化成需要凑出dp[10],dp[9],dp[6]的最小数目
			int dp[] = new int[amount + 1];

			dp[0] = 0;

			for (int i = 1; i <= amount; i++) {
				dp[i] = Integer.MAX_VALUE;
				for (int j = 0; j < n; j++) {
					if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
					}
				}
			}
			return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)


	//Date:2020-06-08 23:04:06
	//执行耗时:14 ms,击败了85.82% 的Java用户
	//基于V1，空间压缩
	class SolutionV2 {
		public int coinChange(int[] coins, int amount) {
			if (coins == null || coins.length == 0) return -1;
			int n = coins.length;

			//dp[i][value] 代表用coins[0]~coins[i] 凑出value的最小币数
			int[] dp = new int[amount + 1];
			Arrays.fill(dp, amount + 1);
			dp[0] = 0;
			for (int i = 0; i < n; i++) {
				for (int j = coins[i]; j <= amount; j++) {
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}

			return dp[amount] == amount + 1 ? -1 : dp[amount];
		}
	}

	//Date:2020-06-08 22:52:36
	//执行耗时:24 ms,击败了31.16% 的Java用户
	class SolutionV1 {
		public int coinChange(int[] coins, int amount) {
			if (coins == null || coins.length == 0) return -1;
			int n = coins.length;

			//dp[i][value] 代表用coins[0]~coins[i] 凑出value的最小币数
			int[][] dp = new int[n][amount + 1];

			for (int j = 0; j <= amount; j++) {
				if (j % coins[0] == 0) {
					dp[0][j] = j / coins[0];
				} else {
					dp[0][j] = amount + 1;
				}
			}

			for (int i = 1; i < n; i++) {
				for (int j = 0; j <= amount; j++) {
					dp[i][j] = dp[i - 1][j];
					if (j >= coins[i]) {
						dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
					}
				}
			}

			return dp[n - 1][amount] == amount + 1 ? -1 : dp[n - 1][amount];
		}
	}

}
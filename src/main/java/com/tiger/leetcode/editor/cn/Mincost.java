//256.粉刷房子
//这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，
// 你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小，返回最小的费用。
//费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用
package com.tiger.leetcode.editor.cn;

/**
 * @auther Jack
 * @date 2020/6/25 12:56
 */

public class Mincost {

	public class Solution {
		/**
		 * @param costs: n x 3 cost matrix
		 * @return: An integer, the minimum cost to paint all houses
		 */
		public int minCost(int[][] costs) {
			if (costs == null || costs.length == 0) return 0;

			int n = costs.length;
			//dp[i][0]表示第i个房子涂红色的费用
			int[][] dp = new int[n][3];

			dp[0][0] = costs[0][0];
			dp[0][1] = costs[0][1];
			dp[0][2] = costs[0][2];

			for (int i = 1; i < n; i++) {

				for (int j = 0; j < 3; j++) {

					dp[i][j] = Integer.MAX_VALUE;
					for (int k = 0; k < 3; k++) {
						if (k != j) {
							dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
						}
					}
					dp[i][j] += costs[i][j];
				}
			}

			return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
		}
	}
}

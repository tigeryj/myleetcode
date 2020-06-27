//361.炸弹攻击
//给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'), 返回你可以用一个炸弹杀死的
//最大敌人数. 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁.
package com.tiger.leetcode.editor.cn;

/**
 * @auther Jack
 * @date 2020/6/27 14:40
 */

public class maxKilledEnemies {

	public class Solution {
		/**
		 * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
		 * @return: an integer, the maximum enemies you can kill using one bomb
		 */
		public int maxKilledEnemies(char[][] grid) {
			if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
			int m = grid.length;
			int n = grid[0].length;
			int[][][] dp = new int[m + 2][n + 2][4];

			int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3;
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (grid[i - 1][j - 1] == 'E') {
						dp[i][j][LEFT] = dp[i - 1][j][LEFT] + 1;
						dp[i][j][UP] = dp[i][j - 1][UP] + 1;
					} else if (grid[i - 1][j - 1] == '0') {
						dp[i][j][LEFT] = dp[i - 1][j][LEFT];
						dp[i][j][UP] = dp[i][j - 1][UP];
					}
				}
			}

			for (int i = m; i >= 1; i--) {
				for (int j = n; j >= 1; j--) {
					if (grid[i - 1][j - 1] == 'E') {
						dp[i][j][RIGHT] = dp[i + 1][j][RIGHT] + 1;
						dp[i][j][DOWN] = dp[i][j + 1][DOWN] + 1;
					} else if (grid[i - 1][j - 1] == '0') {
						dp[i][j][RIGHT] = dp[i + 1][j][RIGHT];
						dp[i][j][DOWN] = dp[i][j + 1][DOWN];
					}
				}
			}

			int max = 0;
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (grid[i - 1][j - 1] == 'E' || grid[i - 1][j - 1] == 'W') {
						continue;
					}
					int sum = 0;
					for (int k = 0; k < 4; k++) {
						sum += dp[i][j][k];
					}
					max = Math.max(max, sum);
				}
			}

			return max;
		}
	}
}

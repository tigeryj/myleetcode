//64.最小路径和
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

package com.tiger.leetcode.editor.cn;

public class MinimumPathSum {
	public static void main(String[] args) {
		Solution solution = new MinimumPathSum().new Solution();
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	//滚动数组
	class Solution {
		public int minPathSum(int[][] grid) {
			if (grid == null || grid.length == 0) return 0;

			int m = grid.length, n = grid[0].length;
			int dp[][] = new int[2][n];
			int now = 0, old = 0;
			for (int i = m - 1; i >= 0; i--) {
				old = now;
				now = 1 - now;
				for (int j = n - 1; j >= 0; j--) {
					if (i == m - 1 && j == n - 1) {
						dp[now][j] = grid[i][j];
					} else if (i == m - 1) {
						dp[now][j] = dp[now][j + 1] + grid[i][j];
					} else if (j == n - 1) {
						dp[now][j] = dp[old][j] + grid[i][j];
					} else {
						dp[now][j] = Math.min(dp[old][j], dp[now][j + 1]) + grid[i][j];
					}
				}
			}
			return dp[now][0];
		}

	}

	//leetcode submit region end(Prohibit modification and deletion)

	//执行耗时:3 ms,击败了89.87% 的Java用户
	//内存消耗:42.3 MB,击败了36.36% 的Java用户
	//Date:2020-05-31 23:25:37
	class SolutionV2 {

		public int minPathSum(int[][] grid) {
			if (grid == null || grid.length == 0) return 0;

			//dp[i][j] means the min sum from grid[i][j] to grid[m-1][n-1]
			int m = grid.length, n = grid[0].length;

			int dp[][] = new int[m][n];

			for (int i = m - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (i == m - 1 && j == n - 1) {
						dp[i][j] = grid[i][j];
					} else if (i == m - 1) {
						dp[i][j] = dp[i][j + 1] + grid[i][j];
					} else if (j == n - 1) {
						dp[i][j] = dp[i + 1][j] + grid[i][j];
					} else {
						dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
					}
				}
			}
			return dp[0][0];

		}

	}

	//Date:2020-05-31 22:11:47
	//Time Limit Exceeded
	class SolutionV1 {
		int[][] direction = {{1, 0}, {0, 1}};
		int minSum = Integer.MAX_VALUE;
		int m, n;

		public int minPathSum(int[][] grid) {
			if (grid == null || grid.length == 0) return 0;
			m = grid.length;
			n = grid[0].length;

			dfs(grid, 0, 0, 0);

			return minSum;
		}

		private void dfs(int[][] grid, int i, int j, int sum) {
			if (i == m - 1 && j == n - 1) {
				minSum = Math.min(sum + grid[i][j], minSum);
			}

			for (int k = 0; k < 2; k++) {
				int nextX = i + direction[k][0];
				int nextY = j + direction[k][1];

				if (nextX < m && nextY < n) {
					dfs(grid, nextX, nextY, sum + grid[i][j]);
				}
			}
		}
	}

}
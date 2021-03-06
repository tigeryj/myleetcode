//63.不同路径 II
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划

package com.tiger.leetcode.editor.cn;

public class UniquePathsIi {
	public static void main(String[] args) {
		Solution solution = new UniquePathsIi().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			int dp[][] = new int[m][n];

			//Date:2020-06-25 10:22:04
			//执行耗时:1 ms,击败了56.30% 的Java用户
			for (int i = m - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (obstacleGrid[i][j] == 1) {
						dp[i][j] = 0;
					} else if (i == m - 1 && j == n - 1) {
						dp[i][j] = 1;
					} else if (i == m - 1) {
						dp[i][j] = dp[i][j + 1];
					} else if (j == n - 1) {
						dp[i][j] = dp[i + 1][j];
					} else {
						dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
					}
				}
			}
			return dp[0][0];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-05 21:54:37
	//执行耗时:1 ms,击败了64.15% 的Java用户
	class SolutionV1 {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			int dp[][] = new int[m + 1][n + 1];
			dp[m][n - 1] = 1;
			dp[m - 1][n] = 1;
			for (int i = m - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (obstacleGrid[i][j] == 1) {
						dp[i][j] = 0;
					} else if (i == m - 1) {
						dp[i][j] = dp[i][j + 1];
					} else if (j == n - 1) {
						dp[i][j] = dp[i + 1][j];
					} else {
						dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
					}
				}
			}
			return dp[0][0];
		}
	}

}
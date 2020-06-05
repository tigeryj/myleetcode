//62.不同路径
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划

package com.tiger.leetcode.editor.cn;

public class UniquePaths {
	public static void main(String[] args) {
		Solution solution = new UniquePaths().new Solution();
		System.out.println(solution.uniquePaths(7, 3));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//执行耗时:0 ms,击败了100.00% 的Java用户
	//Date:2020-06-05 21:40:29
	class Solution {
		public int uniquePaths(int m, int n) {
			if (m <= 0 || n <= 0) return 0;

			int[][] dp = new int[m][n];
			dp[m - 1][n - 1] = 1;
			for (int row = m - 1; row >= 0; row--) {
				for (int col = n - 1; col >= 0; col--) {
					if (row == m - 1 || col == n - 1) {
						dp[row][col] = 1;
					} else {
						dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
					}
				}
			}
			return dp[0][0];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
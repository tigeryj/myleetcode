//130.被围绕的区域
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.tiger.leetcode.editor.cn;

public class SurroundedRegions {
	public static void main(String[] args) {
		Solution solution = new SurroundedRegions().new Solution();
		solution.solve(new char[][]{{'X'}});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-05-24 11:18:09
	//执行耗时:2 ms,击败了98.45% 的Java用户
	class Solution {
		private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		private int rows, cols;

		public void solve(char[][] board) {
			if (board == null || board.length == 0 || board[0].length == 0) return;

			rows = board.length;
			cols = board[0].length;

			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					if ((x == 0 || y == 0 || x == rows - 1 || y == cols - 1) && board[x][y] == 'O') {
						dfs(board, x, y);
					}
				}
			}

			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					if (board[x][y] == 'O') {
						board[x][y] = 'X';
					} else if (board[x][y] == '$') {
						board[x][y] = 'O';
					}
				}
			}
		}

		private void dfs(char[][] board, int x, int y) {
			board[x][y] = '$';
			for (int i = 0; i < 4; i++) {
				int nextX = x + directions[i][0];
				int nextY = y + directions[i][1];

				if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && board[nextX][nextY] == 'O') {
					dfs(board, nextX, nextY);
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
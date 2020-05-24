//200.岛屿数量
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;

public class NumberOfIslands {
	public static void main(String[] args) {
		Solution solution = new NumberOfIslands().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//BFS
	//Date:2020-05-22 22:33:14
	class Solution {
		private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		private int rows, cols;

		public int numIslands(char[][] grid) {
			if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
				return 0;
			}
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			LinkedList<Integer> queue = new LinkedList<>();
			rows = grid.length;
			cols = grid[0].length;
			int num = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == '1' && !visited[i][j]) {
						num++;
						//小技巧
						queue.addLast(i * cols + j);
						visited[i][j] = true;
						while (!queue.isEmpty()) {
							Integer first = queue.removeFirst();
							int x = first / cols;
							int y = first % cols;
							for (int k = 0; k < 4; k++) {
								int nextX = x + direction[k][0];
								int nextY = y + direction[k][1];
								if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == '1') {
									visited[nextX][nextY] = true;
									queue.addLast(nextX * cols + nextY);
								}
							}
						}
					}
				}
			}
			return num;
		}

		private boolean inArea(int x, int y) {
			return x >= 0 && y >= 0 && x < rows && y < cols;
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)

	//DFS
	class SolutionV1 {
		private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		private int xMax, yMax;

		public int numIslands(char[][] grid) {
			if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
				return 0;
			}
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			xMax = grid.length - 1;
			yMax = grid[0].length - 1;
			int num = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '1' && !visited[i][j]) {
						num++;
						dfs(grid, i, j, visited);
					}
				}
			}
			return num;

		}

		private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
			visited[x][y] = true;
			for (int k = 0; k < 4; k++) {
				int newX = x + direction[k][0];
				int newY = y + direction[k][1];
				if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
					dfs(grid, newX, newY, visited);
				}
			}

		}

		private boolean inArea(int x, int y) {
			return x >= 0 && y >= 0 && x <= xMax && y <= yMax;
		}
	}
}
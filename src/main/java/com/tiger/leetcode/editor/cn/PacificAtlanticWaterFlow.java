//417.太平洋大西洋水流问题
//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		Solution solution = new PacificAtlanticWaterFlow().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-05-24 12:59:39
	//执行耗时:5 ms,击败了98.20% 的Java用户
	class Solution {

		private boolean[][] pacific, atlantic;
		private int rows, cols;
		private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		public List<List<Integer>> pacificAtlantic(int[][] matrix) {
			List<List<Integer>> res = new ArrayList<>();
			if (matrix == null || matrix.length == 0) return res;

			rows = matrix.length;
			cols = matrix[0].length;
			pacific = new boolean[rows][cols];
			atlantic = new boolean[rows][cols];

			for (int x = 0; x < rows; x++) {
				dfs(matrix, pacific, x, 0);
				dfs(matrix, atlantic, x, cols - 1);
			}

			for (int y = 0; y < cols; y++) {
				dfs(matrix, pacific, 0, y);
				dfs(matrix, atlantic, rows - 1, y);
			}

			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					if (pacific[x][y] && atlantic[x][y]) {
						res.add(Arrays.asList(x, y));
					}
				}
			}
			return res;
		}

		private void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = x + directions[i][0];
				int nextY = y + directions[i][1];
				if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !visited[nextX][nextY] && matrix[nextX][nextY] >= matrix[x][y]) {
					dfs(matrix, visited, nextX, nextY);
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
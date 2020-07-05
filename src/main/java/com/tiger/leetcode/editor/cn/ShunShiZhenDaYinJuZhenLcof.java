//剑指 Offer 29.顺时针打印矩阵
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
// 1 2 3 4
// 5 6 7 8
// 9101112
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组

package com.tiger.leetcode.editor.cn;

public class ShunShiZhenDaYinJuZhenLcof {
	public static void main(String[] args) {
		Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
//		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(solution.spiralOrder(new int[][]{{6, 9, 7}}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-07-05 23:00:21
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		int[] res;
		int index;
		int[][] matrix;

		public int[] spiralOrder(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
				return new int[0];
			}
			int m = matrix.length;
			int n = matrix[0].length;
			int len = m * n;
			res = new int[len];
			this.matrix = matrix;

			order(0, 0, m - 1, n - 1);

			return res;
		}

		//m = 2,n = 1
		private void order(int x, int y, int m, int n) {
			if (x > m || y > n) return;

			for (int j = y; j <= n; j++) {
				res[index++] = matrix[x][j];
			}

			for (int i = x + 1; i <= m - 1; i++) {
				res[index++] = matrix[i][n];
			}

			if (m > x) {
				for (int j = n; j >= y; j--) {
					res[index++] = matrix[m][j];
				}
			}

			if (n > y) {
				for (int i = m - 1; i >= x + 1; i--) {
					res[index++] = matrix[i][y];
				}
			}

			order(x + 1, y + 1, m - 1, n - 1);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
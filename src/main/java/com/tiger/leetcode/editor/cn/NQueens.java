//51.N皇后
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		Solution solution = new NQueens().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//执行耗时:5 ms,击败了53.10% 的Java用户
	//Date:2020-05-24 16:32:03
	class Solution {

		private boolean[] colsVisited;
		private boolean[] dia1Visited;
		private boolean[] dia2Visited;
		private int N;

		/**
		 * 00 01 02 03 04
		 * 10 11 12 13 14
		 * 20 21 22 23 24
		 * 30 31 32 33 34
		 * 40 41 42 43 44
		 * <p>
		 * dia1 对角线 之和是0，1，2，3，4，5，6，7，8
		 * dia2 对角线 之差是-4,-3,-2,-1,0,1,2,3,4 每一位都加上n-1后就是0，1，2，3，4，5，6，7，8
		 */
		public List<List<String>> solveNQueens(int n) {
			List<List<String>> res = new ArrayList<>();
			if (n <= 0) return res;
			N = n;
			colsVisited = new boolean[N];
			dia1Visited = new boolean[2 * N - 1];
			dia2Visited = new boolean[2 * N - 1];

			List<Integer> colPath = new ArrayList<>();
			putQueen(res, 0, colPath);

			return res;
		}

		private void putQueen(List<List<String>> res, int rowIndex, List<Integer> colPath) {
			if (rowIndex == N) {
				res.add(generateBoard(colPath));
			}

			for (int colIndex = 0; colIndex < N; colIndex++) {
				if (!colsVisited[colIndex] &&
					!dia1Visited[rowIndex + colIndex] && !dia2Visited[rowIndex - colIndex + N - 1]) {

					colsVisited[colIndex] = true;
					dia1Visited[rowIndex + colIndex] = true;
					dia2Visited[rowIndex - colIndex + N - 1] = true;
					colPath.add(colIndex);

					putQueen(res, rowIndex + 1, colPath);

					colsVisited[colIndex] = false;
					dia1Visited[rowIndex + colIndex] = false;
					dia2Visited[rowIndex - colIndex + N - 1] = false;
					colPath.remove(colPath.size() - 1);
				}
			}
		}

		private List<String> generateBoard(List<Integer> path) {
			List<String> board = new ArrayList<>();

			for (int rowIndex = 0; rowIndex < N; rowIndex++) {
				char[] cols = new char[N];
				for (int colIndex = 0; colIndex < N; colIndex++) {
					if (colIndex == path.get(rowIndex)) {
						cols[colIndex] = 'Q';
					} else {
						cols[colIndex] = '.';
					}
				}
				board.add(new String(cols));
			}
			return board;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
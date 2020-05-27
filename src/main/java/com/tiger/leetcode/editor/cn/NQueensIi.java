//52.N皇后 II
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package com.tiger.leetcode.editor.cn;

public class NQueensIi {
	public static void main(String[] args) {
		Solution solution = new NQueensIi().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * 00 01 02 03 04
	 * 10 11 12 13 14
	 * 20 21 22 23 24
	 * 30 31 32 33 34
	 * 40 41 42 43 44
	 * <p>
	 * dia1Visited 对角线 之和是0，1，2，3，4，5，6，7，8
	 * dia2Visited 对角线 之差是-4,-3,-2,-1,0,1,2,3,4 每一位都加上n-1后就是0，1，2，3，4，5，6，7，8
	 */
	class Solution {

		boolean[] colVisited;
		boolean[] dia1Visited;
		boolean[] dia2Visited;
		int count;

		public int totalNQueens(int n) {
			if (n < 1) return 0;
			colVisited = new boolean[n];
			dia1Visited = new boolean[2 * n - 1];
			dia2Visited = new boolean[2 * n - 1];

			addQueueInARow(0, n);

			return count;
		}

		private void addQueueInARow(int rowIndex, int n) {
			if (rowIndex == n) {
				count++;
				return;
			}
			for (int colIndex = 0; colIndex < n; colIndex++) {
				if (!colVisited[colIndex] && !dia1Visited[rowIndex + colIndex] && !dia2Visited[rowIndex - colIndex + n - 1]) {
					colVisited[colIndex] = true;
					dia1Visited[rowIndex + colIndex] = true;
					dia2Visited[rowIndex - colIndex + n - 1] = true;

					addQueueInARow(rowIndex + 1, n);

					colVisited[colIndex] = false;
					dia1Visited[rowIndex + colIndex] = false;
					dia2Visited[rowIndex - colIndex + n - 1] = false;
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
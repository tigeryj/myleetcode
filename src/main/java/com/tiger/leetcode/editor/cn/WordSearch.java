//79.单词搜索
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法

package com.tiger.leetcode.editor.cn;

public class WordSearch {
	public static void main(String[] args) {
		Solution solution = new WordSearch().new Solution();
		/*
			E S E
			C C E
			B F D
			A S A
		 */
		char[][] board = {{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}};


		System.out.println(solution.exist(board, "ABCCED"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//	Date:2020-05-19 17:06:55
	//执行耗时:8 ms,击败了53.99% 的Java用户
	class Solution {
		private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		public boolean exist(char[][] board, String word) {
			if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
				return false;
			}

			boolean[][] visited = new boolean[board.length][board[0].length];

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (searchWord(board, visited, i, j, word, 0)) return true;
				}
			}
			return false;
		}

		//从坐标x、y处开始寻找word中index起始的字符串
		private boolean searchWord(char[][] board, boolean[][] visited, int x, int y, String word, int index) {

			if (index == word.length() - 1) return board[x][y] == word.charAt(index);

			if (board[x][y] == word.charAt(index)) {
				for (int i = 0; i < 4; i++) {
					int nextX = d[i][0] + x;
					int nextY = d[i][1] + y;
					if (valid(nextX, nextY, visited)) {
						visited[x][y] = true;
						if (searchWord(board, visited, nextX, nextY, word, index + 1)) return true;
						visited[x][y] = false;
					}
				}
			}

			return false;
		}

		private boolean valid(int nextX, int nextY, boolean[][] visited) {
			return nextX >= 0 && nextY >= 0 && nextX < visited.length && nextY < visited[0].length && !visited[nextX][nextY];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
//37.解数独
//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法

package com.tiger.leetcode.editor.cn;

public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        solution.solveSudoku(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
     *Date:2020-05-27 23:29:13
     *执行耗时:3 ms,击败了91.32% 的Java用户
     */

    class Solution {
        boolean[][] v1;
        boolean[][] v2;
        boolean[][] v3;

        public void solveSudoku(char[][] board) {
            // 记录横向已经有的记录
            v1 = new boolean[9][10];
            // 记录纵向已经有的记录
            v2 = new boolean[9][10];
            // 记录3宫格已经有的记录
            v3 = new boolean[9][10];
            // 预处理
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int idx = board[i][j] - '0';
                        v1[i][idx] = true;
                        v2[j][idx] = true;
                        v3[(i / 3) * 3 + (j / 3)][idx] = true;
                    }
                }
            }
            backTracking(board, 0, 0);
        }

        private boolean backTracking(char[][] board, int i, int j) {
            // 终止条件
            if (i == 9) return true;
            // 不需要决策
            if (board[i][j] != '.') {
                return backTracking(board, j == 8 ? i + 1 : i, (j + 1) % 9);
            }
            // 开始决策
            for (int k = 1; k <= 9; k++) {
                // 该数字不能使用
                if (v1[i][k] || v2[j][k] || v3[(i / 3) * 3 + (j / 3)][k]) continue;

                v1[i][k] = true;
                v2[j][k] = true;
                v3[(i / 3) * 3 + (j / 3)][k] = true;
                board[i][j] = (char) (k + '0');

                if (backTracking(board, j == 8 ? (i + 1) : i, (j + 1) % 9)) {
                    return true;
                }

                v1[i][k] = false;
                v2[j][k] = false;
                v3[(i / 3) * 3 + (j / 3)][k] = false;
                board[i][j] = '.';
            }

            return false;
        }
    }

    class SolutionV1 {
        boolean[][] rowVisited = new boolean[9][10];
        boolean[][] colVisited = new boolean[9][10];

        boolean[][] blockVisited = new boolean[9][10];

        public void solveSudoku(char[][] board) {
            if (board == null || board.length != 9) throw new IllegalArgumentException();

            //预处理，每一行、每一列、每一块已经填了哪些数字
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0';
                        rowVisited[i][num] = true;
                        colVisited[j][num] = true;
                        blockVisited[(i / 3) * 3 + j / 3][num] = true;
                    }
                }
            }

            dfs(board, 0, 0);
        }

        private boolean dfs(char[][] board, int x, int y) {
            if (x == 9) {
                return true;
            }

            int nextY = (y + 1) % 9;
            int nextX = nextY == 0 ? x + 1 : x;

            if (board[x][y] == '.') {
                for (int num = 1; num <= 9; num++) {
                    if (!rowVisited[x][num] && !colVisited[y][num] && !blockVisited[(x / 3) * 3 + y / 3][num]) {

                        board[x][y] = (char) (num + '0');

                        rowVisited[x][num] = true;
                        colVisited[y][num] = true;
                        blockVisited[(x / 3) * 3 + y / 3][num] = true;

                        if (dfs(board, nextX, nextY)) return true;

                        rowVisited[x][num] = false;
                        colVisited[y][num] = false;
                        blockVisited[(x / 3) * 3 + y / 3][num] = false;

                        board[x][y] = '.';
                    }
                }
            } else {
                return dfs(board, nextX, nextY);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
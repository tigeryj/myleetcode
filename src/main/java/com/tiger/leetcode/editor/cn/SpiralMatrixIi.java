// [59] 螺旋矩阵 II
//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1050 👎 0


package com.tiger.leetcode.editor.cn;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curOrder;
        public int[][] generateMatrix(int n) {
            if (n <= 0) return new int[0][0];
            int[][] ans = new int[n][n];
            curOrder = 0;
            dfs(1, 0, 0, ans);
            return ans;
        }
        private void dfs(int cur, int x, int y, int[][] ans) {
            if (cur > ans.length * ans.length) return;
            ans[x][y] = cur;
            int nextX = x + d[curOrder][0];
            int nextY = y + d[curOrder][1];
            if (nextX < 0 || nextX == ans.length || nextY < 0 || nextY == ans.length || ans[nextX][nextY] != 0) {
                curOrder = (curOrder + 1) % 4;
                nextX = x + d[curOrder][0];
                nextY = y + d[curOrder][1];
            }
            dfs(cur + 1, nextX, nextY, ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

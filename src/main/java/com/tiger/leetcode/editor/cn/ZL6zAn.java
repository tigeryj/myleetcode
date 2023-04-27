// [剑指 Offer II 105] 岛屿的最大面积
//给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1
//,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0
//,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出: 6
//解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// 
//输入: grid = [[0,0,0,0,0,0,0,0]]
//输出: 0 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] is either 0 or 1 
// 
//
// 
//
// 注意：本题与主站 695 题相同： https://leetcode-cn.com/problems/max-area-of-island/ 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 79 👎 0


package com.tiger.leetcode.editor.cn;

public class ZL6zAn {
    public static void main(String[] args) {
        Solution solution = new ZL6zAn().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int m = grid.length;
            int n = grid[0].length;
            visited = new boolean[m][n];


            int sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    sum = Math.max(sum, dfs(grid, i, j ));
                }
            }
            return sum;
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || visited[i][j]) return 0;
            visited[i][j] = true;
            int s = 1;
            for (int k = 0; k < direction.length; k++) {
                s += dfs(grid, i + direction[k][0], j + direction[k][1]);
            }
            return s;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

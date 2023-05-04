// [54] 螺旋矩阵
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1374 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 向量法
     * 注意点：
     * 1.终止条件
     * 2.方向切换的技巧
     */
    class Solution {
        int[][] direction;
        boolean[][] visited;

        public List<Integer> spiralOrder(int[][] matrix) {
            // 定义运动偏移量,顺时针
            direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            // 定义是否访问过该位置
            visited = new boolean[matrix.length][matrix[0].length];
            List<Integer> res = new LinkedList();
            track(matrix, 0, 0, 0, res);
            return res;
        }

        private void track(int[][] matrix, int x, int y, int order, List<Integer> path) {
            // 长度达标，终止递归
            if (path.size() == (matrix.length) * (matrix[0].length)) return;

            // 加入路径
            path.add(matrix[x][y]);
            visited[x][y] = true;

            int nextX = direction[order][0] + x;
            int nextY = direction[order][1] + y;
            // 如果下一跳已经访问过了需要调整方向
            if (nextX == matrix.length || nextX < 0 || nextY == matrix[0].length || nextY < 0 || visited[nextX][nextY]) {
                order = (order + 1) % 4;
                nextX = direction[order][0] + x;
                nextY = direction[order][1] + y;
            }

            track(matrix, nextX, nextY, order, path);
        }
    }

    /**
     * 朴素法，四个边分别遍历，然后递归。需要注意重复问题
     */
    class SolutionV1 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> path = new LinkedList();
            track(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, path);
            return path;
        }
        private void track(int[][] matrix, int m1, int n1, int m2, int n2, List<Integer> path) {
            if (m1 > m2 || n1 > n2) return;
            for (int j = n1; j <= n2; j++) {
                path.add(matrix[m1][j]);
            }

            for (int i = m1 + 1; i <= m2; i++) {
                path.add(matrix[i][n2]);
            }

            // 注意不要和m1行重复
            for (int j = n2 - 1; j >= n1 && m2 > m1; j--) {
                path.add(matrix[m2][j]);
            }

            // 注意不要和n2行重复
            for (int i = m2 - 1; i >= m1 + 1 && n1 < n2; i--) {
                path.add(matrix[i][n1]);
            }

            track(matrix, m1 + 1, n1 + 1, m2 - 1, n2 - 1, path);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

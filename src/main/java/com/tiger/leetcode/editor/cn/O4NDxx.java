// [剑指 Offer II 013] 二维子矩阵的和
//给定一个二维矩阵 matrix，以下类型的多个请求： 
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角
// (row2, col2) 的子矩阵的元素总和。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200
// 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 
// 最多调用 10⁴ 次 sumRegion 方法 
// 
//
// 
//
// 
// 注意：本题与主站 304 题相同： https://leetcode-cn.com/problems/range-sum-query-2d-
//immutable/ 
//
// Related Topics 设计 数组 矩阵 前缀和 👍 70 👎 0


package com.tiger.leetcode.editor.cn;

public class O4NDxx {
    public static void main(String[] args) {

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] sum;

        /**
         * 先初始化处理一下
         * @param matrix
         */
        public NumMatrix(int[][] matrix) {
            this.sum = new int[matrix.length + 1][matrix[0].length + 1];

            for (int i = 1; i < sum.length; i++) {
                for (int j = 1; j < sum[0].length; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i - 1][j - 1] - sum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
        }
    }

    /**
     * 朴素思路
     */
    class NumMatrixV1 {
        private int[][] matrix;

        public NumMatrixV1(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2 ; j++) {
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}

// [剑指 Offer II 040] 矩阵中最大的矩形
//给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。 
//
// 注意：此题 matrix 输入格式为一维 01 字符串数组。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = ["10100","10111","11111","10010"]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = ["0"]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = ["1"]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = ["00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// 
//
// 注意：本题与主站 85 题相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-
//rectangle/ 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 74 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Stack;

public class PLYXKQ {
    public static void main(String[] args) {
        Solution solution = new PLYXKQ().new Solution();
        String[] strings = {"10100", "10111", "11111", "10010"};
        System.out.println(solution.maximalRectangle(strings));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(String[] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length() == 0) return 0;
            int[][] m = new int[matrix.length][matrix[0].length()];
            for (int i = 0; i < matrix.length; i++) {
                String s = matrix[i];
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '1') {
                        m[i][j] = i > 0 ? m[i - 1][j] + 1 : 1;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < m.length; i++) {
                res = Math.max(res, maxRactangle(m[i]));
            }
            return res;
        }

        /**
         * nums[i]代表i位置下柱状的高度,求出可以组成的面积最大的矩形。问题转化为剑指offer39题
         *
         * @param nums
         * @return
         */
        private int maxRactangle(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = st.peek();
                }
                st.push(i);
            }
            st.clear();
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    right[i] = nums.length;
                } else {
                    right[i] = st.peek();
                }
                st.push(i);
            }
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i] * (right[i] - left[i] - 1));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

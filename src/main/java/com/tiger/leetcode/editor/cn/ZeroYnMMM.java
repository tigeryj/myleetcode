// [剑指 Offer II 039] 直方图最大矩形面积
//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-
//histogram/ 
//
// Related Topics 栈 数组 单调栈 👍 83 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Stack;

public class ZeroYnMMM {
    public static void main(String[] args) {
        Solution solution = new ZeroYnMMM().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**1.思路：暴力法，枚举两个边界，然后找到在这个边界下，找到最小的高度,o(n*n)
         * 2.按照每个柱子的高度去枚举，分别找到其最左边和最右边的第一个小于它的边界，这个就知道以当前柱子的高度的最大矩形面积
         * 问题可以转化为
         * 1.求小于当前元素的左边的第一个元素
         * 2.求小于当前元素的右边的第一个元素
         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            Stack<Integer> st = new Stack<>();
            int[] left = new int[heights.length];
            int[] right = new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
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
            for (int i = heights.length - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    right[i] = heights.length;
                } else {
                    right[i] = st.peek();
                }
                st.push(i);
            }
            int res = 0;
            for (int i = 0; i < left.length; i++) {
                res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

//120.三角形最小路径和
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        solution.minimumTotal(input);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;

            int n = triangle.size();
            int[][] dp = new int[n + 1][triangle.get(n - 1).size() + 1];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class SolutionV3 {

        //Date:2020-05-29 22:17:52
        //执行耗时:2 ms,击败了97.16% 的Java用户
        //内存消耗:39.6 MB,击败了8.70% 的Java用户
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            int N = triangle.size();
            int[] dp = new int[N + 1];

            for (int level = N - 1; level >= 0; level--) {
                for (int index = 0; index <= level; index++) {
                    dp[index] = Math.min(dp[index], dp[index + 1]) + triangle.get(level).get(index);
                }
            }
            return dp[0];
        }

    }


    //Date:2020-05-29 22:08:13
    //执行耗时:1 ms,击败了100.00% 的Java用户
    //内存消耗:39.3 MB,击败了8.70% 的Java用户
    class SolutionV2 {

        Integer[][] cache;

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            cache = new Integer[triangle.size()][triangle.size()];
            return minimum(triangle, 0, 0);
        }

        private int minimum(List<List<Integer>> triangle, int level, int index) {

            if (cache[level][index] != null) {
                return cache[level][index];
            }

            if (level == triangle.size() - 1) {
                return cache[level][index] = triangle.get(level).get(index);
            }

            int left = minimum(triangle, level + 1, index);
            int right = minimum(triangle, level + 1, index + 1);

            return cache[level][index] = Math.min(left, right) + triangle.get(level).get(index);
        }
    }

    //Time Limit Exceeded
    class SolutionV1 {
        int max = Integer.MAX_VALUE;

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            backTrack(triangle, 1, 0, triangle.get(0).get(0));
            return max;
        }

        private void backTrack(List<List<Integer>> triangle, int level, int index, int sum) {
            if (triangle.size() == level) {
                max = Math.min(max, sum);
                return;
            }
            backTrack(triangle, level + 1, index, sum + triangle.get(level).get(index));
            backTrack(triangle, level + 1, index + 1, sum + triangle.get(level).get(index + 1));
        }
    }

}
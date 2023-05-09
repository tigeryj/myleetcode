package com.tiger.bagproblem;


public class ZeroOrOne {

    public static void main(String[] args) {
        int[] value = new int[]{2, 5, 10, 6};
        int[] weight = new int[]{3, 1, 3, 2};
        int process = process(value, weight, 3);
        int processV2 = processV2(value, weight, 3);
        System.out.println(process);
        System.out.println(processV2);
    }

    /**
     *
     * @param value 元素价值数组
     * @param weight 元素重量数组
     * @param capacity 总容量
     * @return
     */
    public static int process(int[] value, int[] weight, int capacity) {
        int n = value.length;
        int c = capacity;

        // dp[i][j]表示在0-i个元素里，选择装到容量为j的背包里的最大价值
        int[][] dp = new int[n][c + 1];

        for (int j = 0; j <= c; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        return dp[n - 1][capacity];
    }

    /**
     * 空间优化
     */
    public static int processV2(int[] value, int[] weight, int capacity) {
        int n = value.length;
        int c = capacity;

        // dp[i][j]表示在0-i个元素里，选择装到容量为j的背包里的最大价值
        int[] dp = new int[c + 1];

        for (int i = 0; i < n; i++) {
            for (int j = c; j >= 0; j--) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[capacity];
    }

}

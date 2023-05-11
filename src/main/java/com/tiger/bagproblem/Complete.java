package com.tiger.bagproblem;

public class Complete {

    public static void main(String[] args) {
        System.out.println(process(new int[]{10, 6, 5}, new int[]{5, 2, 3}, 5));
    }

    public static int process(int[] value, int[] weight, int capacity) {
        if (value == null || value.length == 0 || capacity < 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[capacity];
    }
}

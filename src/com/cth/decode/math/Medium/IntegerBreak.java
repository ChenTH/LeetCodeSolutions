package com.cth.decode.math.Medium;

import java.util.Arrays;

public class IntegerBreak {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 4;
        integerBreak(4);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            int max = Integer.MIN_VALUE;
            int j = 0;
            while (j < i) {
                max = Math.max(max, dp[j] * (i - j));
                max = Math.max(max, (j + 1) * (i - j));
                ++j;
            }
            dp[i] = max;
        }
        return dp[n - 1];
    }
}

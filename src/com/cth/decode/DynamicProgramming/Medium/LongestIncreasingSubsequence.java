package com.cth.decode.DynamicProgramming.Medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = {1, -1, 2, -3, 4, -5, 6, -7};
        System.out.println(lengthOfLIS2(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        //dp[i]=1 or 在i之前值小于i的dp值中的最大值加一
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > tmp) {
                        tmp = dp[j];
                    }
                }
            }
            dp[i] = tmp + 1;
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static int lengthOfLIS2(int[] nums) {
        //dp[i]=1 or 在i之前值小于i的dp值中的最大值加一
        int[] dp = new int[nums.length];
        int max = 0;
        for (int x : nums) {
            int i = Arrays.binarySearch(nums, 0, max, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == max) max++;
        }
        return max;
    }
}

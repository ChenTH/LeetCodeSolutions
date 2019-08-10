package com.cth.backup.array.Easy;

/**
 * Created by SherlockTHao on 2017/7/27.
 */
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.print(findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (max < sum) {
                max = sum;
            }
        }
        return (double) max / k;
    }
}

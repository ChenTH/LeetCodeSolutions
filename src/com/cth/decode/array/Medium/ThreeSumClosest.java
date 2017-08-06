package com.cth.decode.array.Medium;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length-1;
            while (start < end) {
                int tmp = nums[i] + nums[start] + nums[end];
                if (tmp > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(res - target) > Math.abs(tmp - target)) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{0,1,2},1);
    }
}

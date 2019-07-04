package com.cth.decode.array.Easy;

import java.util.Arrays;

/**
 * Created by SherlockTHao on 2017/5/21.
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        findUnsortedSubarray(nums);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int beg = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedNums[i]) {
                if (beg == -1) {
                    beg = i;
                    end = i;
                } else {
                    end = i;
                }
            }
        }
        if (beg == -1) {
            return 0;
        } else {
            return end - beg + 1;
        }
    }

    public static int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int beg = -1, end = -2, min = nums[nums.length - 1], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i - 1]);
            if (nums[nums.length - i - 1] > min) beg = nums.length - i - 1;
            if (nums[i] < max) end = i;
        }
        return end - beg + 1;
    }
}

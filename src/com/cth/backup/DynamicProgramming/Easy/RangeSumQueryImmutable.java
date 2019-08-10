package com.cth.backup.DynamicProgramming.Easy;

public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    public static class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            if (nums.length > 0) {
                sums[0] = nums[0];
            }
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sums[j] : sums[j] - sums[i - 1];
        }
    }
}

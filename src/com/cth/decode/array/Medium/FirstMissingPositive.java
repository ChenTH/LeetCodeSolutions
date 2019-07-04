package com.cth.decode.array.Medium;

public class FirstMissingPositive {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int bef = 0;
        int end = length - 1;
        while (bef <= end) {
            while (nums[bef] < 0 && bef < end) {
                bef++;
            }
            while (nums[end] > 0 && end > bef) {
                end--;
            }
            if (bef <= end) {
                int a = nums[end];
                nums[end] = nums[bef];
                nums[bef] = a;
            }
        }

        return 0;
    }
}

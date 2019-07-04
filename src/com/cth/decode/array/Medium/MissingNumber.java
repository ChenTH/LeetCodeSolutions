package com.cth.decode.array.Medium;

public class MissingNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int numsum = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            numsum += nums[i];
            sum += i;
        }
        sum += length;
        return sum - numsum;
    }
}

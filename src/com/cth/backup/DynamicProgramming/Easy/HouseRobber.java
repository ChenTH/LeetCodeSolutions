package com.cth.backup.DynamicProgramming.Easy;

public class HouseRobber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int rob(int[] nums) {
        int length = nums.length;
        int take = 0;
        int notake = 0;
        int maxprofit = 0;
        for (int i = 0; i < length; i++) {
            take = nums[i] + notake;
            notake = maxprofit;
            maxprofit = Math.max(take, notake);
        }
        return maxprofit;
    }
}

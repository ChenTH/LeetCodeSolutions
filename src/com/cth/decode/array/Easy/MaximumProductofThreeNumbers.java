package com.cth.decode.array.Easy;

import java.util.Arrays;

/**
 * Created by SherlockTHao on 2017/7/25.
 */
public class MaximumProductofThreeNumbers {
    public static void main(String[] args){

    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a=nums[0]*nums[1]*nums[2];
        int b=nums[0]*nums[nums.length-1]*nums[nums.length-2];
        return a>b?a:b;
    }
}

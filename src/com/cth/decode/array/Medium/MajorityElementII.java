package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int length = nums.length;
        int num1 = nums[0];
        int count1 = 1;
        int num2 = 0;
        int count2 = 0;
        for (int j = 1; j < length; j++) {
            if (nums[j] == num1) {
                count1++;
            } else if (nums[j] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[j];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[j];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        if (count1 > length / 3) result.add(num1);
        if (count2 > length / 3) result.add(num2);
        return result;
    }
}

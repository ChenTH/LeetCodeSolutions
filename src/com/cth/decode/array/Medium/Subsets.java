package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 2, 3};
        subsets(a);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int a = (int) Math.pow(2, length);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            char[] aString = Integer.toBinaryString(i).toCharArray();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < aString.length; j++) {
                if (aString[aString.length - j - 1] == '1') {
                    list.add(nums[length - j - 1]);
                }
            }
            result.add(list);
        }
        return result;
    }
}

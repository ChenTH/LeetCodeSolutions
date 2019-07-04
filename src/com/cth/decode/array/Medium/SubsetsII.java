package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        int a = (int) Math.pow(2, length);
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
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
        return new ArrayList<List<Integer>>(result);
    }
}

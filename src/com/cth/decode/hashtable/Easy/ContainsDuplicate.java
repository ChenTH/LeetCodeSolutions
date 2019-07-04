package com.cth.decode.hashtable.Easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                return true;
            } else {
                integers.add(nums[i]);
            }
        }
        return false;
    }

}

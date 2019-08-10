package com.cth.backup.hashtable.Easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] i = {1, 2};

        Boolean result = containsNearbyDuplicate(i, 2);
        System.out.println(result);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> integers = new HashSet<Integer>();
        if (nums.length == 0 && k == 0) {
            return false;
        }
        if (k > nums.length - 1) {
            k = nums.length - 1;
        }
        for (int i = 0; i < k + 1; i++) {
            if (integers.contains(nums[i])) {
                return true;
            } else {
                integers.add(nums[i]);
            }
        }
        for (int i = k; i < nums.length; i++) {
            integers.remove(nums[i - k]);
            if (integers.contains(nums[i])) {
                return true;
            } else {
                integers.add(nums[i]);
            }
        }
        return false;
    }

}

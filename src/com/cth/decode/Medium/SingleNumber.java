package com.cth.decode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 1, 2, 2, 3};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}

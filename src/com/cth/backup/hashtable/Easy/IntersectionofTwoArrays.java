package com.cth.backup.hashtable.Easy;

import java.util.HashSet;

public class IntersectionofTwoArrays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] c = intersection(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i] = num;
            i++;
        }
        return result;
    }
}

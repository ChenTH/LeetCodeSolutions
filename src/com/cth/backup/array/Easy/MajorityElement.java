package com.cth.backup.array.Easy;

public class MajorityElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 1, 2, 1, 3, 4, 1, 1, 5, 5, 1, 2, 1, 2, 1};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        int b = majorityElement(a);
        System.out.println(b);
    }

    public static int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    major = nums[i];
                }
            }
        }
        return major;
    }

}

package com.cth.decode.array.Easy;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 1, 2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        int b = removeDuplicates(a);
        System.out.println(b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = 1;
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != a) {
                a = nums[i];
                length++;
                nums[length - 1] = a;
            }
        }
        return length;
    }

}

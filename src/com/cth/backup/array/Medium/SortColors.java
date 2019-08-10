package com.cth.backup.array.Medium;

public class SortColors {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 0};
        sortColors2(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sortColors(int[] nums) {
        int count1 = 0, count2 = 0, count3 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count1++;
            } else if (nums[i] == 1) {
                count2++;
            } else {
                count3++;
            }
        }
        for (int i = 0; i < count1; i++) {
            nums[i] = 0;
        }
        for (int i = count1; i < count1 + count2; i++) {
            nums[i] = 1;
        }
        for (int i = count1 + count2; i < count1 + count2 + count3; i++) {
            nums[i] = 2;
        }
    }

    public static void sortColors2(int[] nums) {//����
        int bef = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0 && i > bef) {
                int tmp = nums[bef];
                nums[bef] = nums[i];
                nums[i] = tmp;
                bef++;
            }
            while (nums[i] == 2 && i <= end) {
                int tmp = nums[end];
                nums[end] = nums[i];
                nums[i] = tmp;
                end--;
            }
        }
    }
}

package com.cth.backup.array.Medium;

public class TwoSumIIInputarrayissorted {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {2, 3, 4};
        twoSum(a, 6);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 1) {
            return null;
        }
        int bef = 0;
        int length = numbers.length;
        int end = numbers.length - 1;
        int[] tar = new int[2];
        while (bef < end) {
            int res = numbers[bef] + numbers[end];
            if (res < target) {
                bef++;
            } else if (res > target) {
                end--;
            } else {
                tar[0] = bef + 1;
                tar[1] = end + 1;
                return tar;
            }
        }
        return tar;
    }
}

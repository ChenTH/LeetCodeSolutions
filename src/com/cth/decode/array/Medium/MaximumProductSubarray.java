package com.cth.decode.array.Medium;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-2};
        System.out.print(maxProduct(a));
    }

    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int bef = -1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int resulttem;
                if (i - bef == 2) {
                    resulttem = nums[bef + 1];
                } else {
                    resulttem = getmax(nums, bef, i);
                }
                if (resulttem > result) {
                    result = resulttem;
                }
                bef = i;
            }
        }
        if (bef != length - 1) {
            int resulttem;
            if (length - bef == 2) {
                resulttem = nums[bef + 1];
            } else {
                resulttem = getmax(nums, bef, length);
            }
            if (resulttem > result) {
                result = resulttem;
            }
        }
        if (result < 0 && bef != -1) {
            result = 0;
        }
        return result;
    }

    public static int getmax(int[] nums, int beg, int fin) {
        int minuscount = 0;//��������
        int length = fin - beg;
        if (fin - beg == 1) {
            return 0;
        }
        int bef = 0;
        int end = 0;
        for (int i = beg + 1; i < fin; i++) {
            if (nums[i] < 0) {
                minuscount++;
                if (minuscount == 1) {
                    bef = i;
                }
                end = i;
            }
        }
        int result = 1;
        if (minuscount % 2 == 0) {
            for (int i = beg + 1; i < fin; i++) {
                result *= nums[i];
            }
        } else {
            int a1 = 1;
            int a2 = 1;
            int a3 = 1;
            for (int i = beg + 1; i < bef; i++) {
                a1 *= nums[i];
            }
            for (int i = bef; i <= end; i++) {
                a2 *= nums[i];
            }
            for (int i = end; i < fin; i++) {
                a3 *= nums[i];
            }
            a3 /= nums[end];
            if (bef == end) {
                if (a1 > a3) {
                    result = a1;
                } else {
                    result = a3;
                }
            } else {
                if (a1 * a2 / nums[end] > a2 * a3 / nums[bef]) {
                    result = a1 * a2 / nums[end];
                } else {
                    result = a2 * a3 / nums[bef];
                }
            }
        }
        return result;
    }
}

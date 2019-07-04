package com.cth.decode.array.Medium;

public class MaximumSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray2(a);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int submax = nums[0];
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (submax < sum) {
                    submax = sum;
                }
            }
            if (submax > max) {
                max = submax;
            }
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int res = nums[0], tmp = res;
        for (int i = 1; i < nums.length; ++i) {
            tmp = (tmp + nums[i]) < nums[i] ? nums[i] : (tmp + nums[i]);
            res = res > tmp ? res : tmp;
        }
        return res;
    }
}

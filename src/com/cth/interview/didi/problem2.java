package com.cth.interview.didi;

/**
 * Created by SherlockTHao on 2017/8/27.
 */
public class problem2 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 2, 3};
        System.out.print(QuickFind(nums, 0, nums.length - 1, 2));
    }

    public static int QuickSortPart(int[] nums, int start, int end) {
        int temp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= temp) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= temp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }

    public static int QuickFind(int[] nums, int start, int end, int idx) {
        if (start < end) {
            int tmp = QuickSortPart(nums, start, end);
            if (tmp == idx) {
                return nums[tmp];
            } else if (tmp < idx) {
                return QuickFind(nums, tmp + 1, end, idx);
            } else {
                return QuickFind(nums, start, tmp - 1, idx);
            }
        }
        return -1;
    }
}

package com.cth.backup.array.Medium;

public class FindPeakElement {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {3, 2, 1};
        System.out.println(findPeakElement2(a));
    }

    public static int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                return i;
            }
        }
        if (nums[length - 2] < nums[length - 1]) {
            return length - 1;
        }
        return 0;
    }

    public static int findPeakElement2(int[] nums) {
        int bef = 0;
        int length = nums.length;
        int end = length - 1;
        int mid = 0;
        while (bef <= end) {
            mid = (end + bef) / 2;
            if (mid != bef) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid - 1]) {
                    end = mid - 1;
                } else {
                    bef = mid + 1;
                }
            } else {//ֻ��mid==bef�Ŀ���
                if (nums[mid] > nums[end]) {
                    return mid;
                } else {
                    return end;
                }
            }
        }
        return mid;
    }
}

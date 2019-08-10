package com.cth.backup.array.Easy;

public class MergeSortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {4, 5, 6, 0, 0, 0};
        int[] b = {1, 2, 3};
        merge(a, 3, b, 3);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;//记录总循环次数
        int index1 = 0;//记录nums1循环到第几个
        int index2 = 0;//记录nums2循环到第几个
        int length = m;//记录新队列长度
        while (index1 < m && index2 < n) {
            if (nums1[i] <= nums2[index2]) {
                i++;
                index1++;
            } else if (nums1[i] > nums2[index2]) {
                for (int k = length - 1; k >= i; k--) {
                    nums1[k + 1] = nums1[k];
                }
                nums1[i] = nums2[index2];
                index2++;
                i++;
                length++;
            }
        }
        if (index1 <= m) {
            if (n != 0 && m != 0) {
                for (int k = 0; k < n - length + m; k++) {
                    nums1[k + length] = nums2[length - m + k];
                }
            } else if (m == 0) {
                for (int k = 0; k < n; k++) {
                    nums1[k] = nums2[k];
                }
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        while (j > -1) nums1[k--] = nums2[j--];
    }
}

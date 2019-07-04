package com.cth.decode.array.Medium;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {5, 1, 3};
        int b = 3;
        System.out.println(search(a, b));

    }

    public static int search(int[] nums, int target) {
        int bef = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (bef < end) {
            mid = (bef + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[bef] > nums[end]) {
                if (nums[mid] > nums[end]) {
                    if (nums[mid] > target) {
                        if (target > nums[end]) {
                            end = mid - 1;
                        } else {
                            bef = mid + 1;
                        }
                    } else {
                        bef = mid + 1;
                    }
                } else {
                    if (nums[mid] < target) {
                        if (target >= nums[bef]) {
                            end = mid - 1;
                        } else {
                            bef = mid + 1;
                        }
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                if (nums[mid] < target) {
                    bef = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        mid = (bef + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else {
            return -1;
        }
    }

    public int search2(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == A[mid]) return mid;
            if (A[l] <= A[r]) {  //�����˳��
                if (target < A[mid]) r = mid - 1;
                else l = mid + 1;
            } else if (A[l] <= A[mid]) {
                if (target > A[mid] || target < A[l]) l = mid + 1;
                else r = mid - 1;
            } else {
                if (target < A[mid] || target > A[r]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
}

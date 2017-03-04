package com.cth.decode.array.Medium;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		System.out.println(findMin1(a));
	}

	public static int findMin(int[] nums) {
		for (int i = 1; i <= nums.length - 1; i++) {
			if (nums[i] < nums[i - 1]) {
				return nums[i];
			}
		}
		return nums[0];
	}

	public static int findMin1(int[] nums) {
		int bef = 0;
		int length = nums.length;
		int end = length - 1;
		int mid = 0;
		if(length==1 || nums[bef]<nums[end]){
			return nums[0];
		}
		while (bef < end) {
			mid = (end + bef) / 2;
			if (nums[mid] > nums[bef]) {
				bef = mid;
			} else {
				end = mid;
			}
		}
		return nums[mid+1];
	}
}

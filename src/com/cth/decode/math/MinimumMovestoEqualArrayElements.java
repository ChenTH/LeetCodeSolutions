package com.cth.decode.math;

public class MinimumMovestoEqualArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2147483647};
		System.out.println(minMoves3(nums));
	}
    public static int minMoves(int[] nums) {//有2147483647时无解
        boolean flag=true;
        int count=0;
        while (flag) {
        	flag=false;
        	int maxIndex=0;
			for (int i = 1; i < nums.length; i++) {
				if(nums[i]>nums[maxIndex]){
					flag=true;
					nums[maxIndex]++;
					maxIndex=i;
				}
				else if (nums[i]==nums[maxIndex]) {
					nums[maxIndex]++;
					maxIndex=i;
				}
				else {
					nums[i]++;
				}
			}
			count++;
		}
        return --count;
    }
    public int minMoves2(int[] nums) {//为一个数之外的其他数加一相当于为这个数减一。
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
    public static int minMoves3(int[] nums) {
        int count=0;
        while (judgeEqual(nums)) {
        	int maxIndex=0;
			for (int i = 1; i < nums.length; i++) {
				if(nums[i]>nums[maxIndex]){
					nums[maxIndex]++;
					maxIndex=i;
				}
				else {
					nums[i]++;
				}
			}
			count++;
		}
        return count;
    }
    public static boolean judgeEqual(int[] nums) {
        boolean flag=false;
        int maxIndex=0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]!=nums[maxIndex]){
				flag=true;
				break;
			}
		}
		return flag;
	}
}

package com.cth.decode.array.Medium;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a={2,3,1,1,4};
		int[] a={1};
		System.out.println(canJump(a));
	}
    public static boolean canJump(int[] nums) {
    	
        int count=0;
        int length=nums.length;
        for (int i = 0; i <= count && count<=length && i<length; i++) {
        	System.out.println(i+":"+count);
			if(nums[i]+i>count){
				count=nums[i]+i;
			}
		}
        return count>=length-1;
    }
}

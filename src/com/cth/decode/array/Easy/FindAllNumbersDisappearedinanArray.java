package com.cth.decode.array.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={4,3,2,7,8,2,3,1};
		findDisappearedNumbers(a);
	}
    public static List<Integer> findDisappearedNumbers(int[] nums) {
    	for(int i=0;i<nums.length;i++){
    		nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
    	}
    	List<Integer> list=new ArrayList<>();
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0){
				list.add(i+1);
			}
		}
		return list;
    }
}

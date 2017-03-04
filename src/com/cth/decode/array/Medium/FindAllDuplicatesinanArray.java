package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={4,3,2,7,8,2,3,1};
		findDuplicates(a);
	}
//    public List<Integer> findDuplicates(int[] nums) {
//    	Set<Integer> set=new HashSet<>();
//    	for(int i=0;i<nums.length;i++){
//    		if(nums[Math.abs(nums[i])-1]>0){
//        		nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
//    		}
//    		else {
//    			set.add(Math.abs(nums[i]));
//			}
//    	}
//    	List<Integer> list=new ArrayList<>(set);
//		return list;
//    }
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list=new ArrayList<>();
    	for(int i=0;i<nums.length;i++){
    		while(nums[i] - 1 != i)
            {
                int temp = nums[nums[i] - 1];
                if(temp == nums[i]) break;
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
    	}
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]-1!=i){
    			list.add(i+1);
    		}
    	}
    	return list;
	}
}

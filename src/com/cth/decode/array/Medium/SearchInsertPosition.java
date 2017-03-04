package com.cth.decode.array.Medium;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1};
		System.out.println(searchInsert(a,2));
	}
    public static int searchInsert(int[] nums, int target) {
    	int length=nums.length;
    	int bef=0;
    	int end=length-1;
    	while(bef<=end){
    		int middle=(end+bef)/2;
    		if(nums[middle]>target){
    			end=middle-1;
    		}
    		else if(nums[middle]<target){
    			bef=middle+1;
    		}
    		else {
				return middle;
			}
    		
    	}
		int middle=(end+bef)/2;
    	if(nums[middle]>target){
    		return middle;
    	}
    	else{
    		return middle+1;
    	}
    }
}

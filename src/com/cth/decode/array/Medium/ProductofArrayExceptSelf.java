package com.cth.decode.array.Medium;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] productExceptSelf(int[] nums) {
    	int length=nums.length;
    	int product=1;
    	int zerocount=0;
    	int zeroindex=0;
    	for(int i=0;i<length;i++){
    		if(nums[i]!=0){
        		product=product*nums[i];
    		}
    		else{
    			zerocount++;
    			zeroindex=i;
    		}
    	}
    	int[] result=new int[length];
    	if(zerocount>1){
    		return result;
    	}
    	else if(zerocount==1){
    		result[zeroindex]=product;
    	}
    	else {
        	for(int i=0;i<length;i++){
            	result[i]=product/nums[i];
        	}
		}
		return result;
    }
}

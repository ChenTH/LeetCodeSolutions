package com.cth.decode.array.Medium;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={5,1,1};
		nextPermutation(a);
	}
    public static void nextPermutation(int[] nums) {
    	int length=nums.length;
    	if(length<=1){
    		return;
    	}
    	int i=nums.length-2;
    	while(i>0 && nums[i]>nums[i+1]){
    		i--;
    	}
    	int j=nums.length-1;
    	while (j>0 && nums[j]<nums[i]) {
			j--;
		}
    	if(i==0 && j==0){
    		for(int k=0;k<nums.length/2;k++){
    			int a=nums[k];
    			nums[k]=nums[length-1-k];
    			nums[length-1-k]=a;
    		}
    		return;
    	}
		int a=nums[j];
		 nums[j]=nums[i];
		nums[i]=a;
		for(int k=i+1;k<=(length-i)/2+i;k++){
			a=nums[k];
			nums[k]=nums[length-k+i];
			nums[length-k+i]=a;
		}
    }
}

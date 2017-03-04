package com.cth.decode.array.Medium;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2};
		removeDuplicates(a);
	}
    public static int removeDuplicates(int[] nums) {
    if(nums.length==0){
    	return 0;
    }
	int length=1;
	int a=nums[0];
	boolean flag=true;
	for(int i=1;i<nums.length;i++){
		if(nums[i]!=a){
			a=nums[i];
			length++;
			nums[length-1]=a;
			flag=false;
		}
		else if(nums[i]==a && flag ==false){
			length++;
			nums[length-1]=a;
			flag=true;
		}
	}
	return length;
}
}

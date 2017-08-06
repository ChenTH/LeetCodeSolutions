package com.cth.decode.array.Easy;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] a={1,2};
   System.out.println(a[0]);
    rotate(a, 3);
    System.out.println(a[0]);
	}
    public static void rotate(int[] nums, int k) {
    	  int length=nums.length;
          int[] aaa = new int[length];
          if(k>length){
          	k=k%length;
          }
          int j=length-k;
          for(int i=0;i<length;i++){
          	if(j>=length)
          	{
          		j=0;
          	}
          	aaa[i]=nums[j];
          	j++;
          }
          for(int i=0;i<length;i++){
        	  nums[i]=aaa[i];
          }
    }

}

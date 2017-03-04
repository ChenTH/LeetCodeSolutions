package com.cth.decode.hashtable.Medium;

import java.util.HashMap;
import java.util.Map;

public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={3, 0, 6, 1, 5};
		hIndex(a);
	}
    public static int hIndex(int[] citations) {
    	int max=0;
    	for(int num : citations){
    		if(max<num){
    			max=num;
    		}
    	}
    	int[] nums=new int[max+1];
    	for(int num : citations){
    		nums[num]++;
    	}
    	int sum=citations.length;
    	int result=0;
    	for(int i=0;i<=max;i++){
    		if(sum>=i){
    			result=i;
    		}
    		sum-=nums[i];
    	}
		return result;
    }
}

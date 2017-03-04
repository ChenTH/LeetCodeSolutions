package com.cth.decode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,2,5,3,5};
		thirdMax(a);
	}
//    public static int thirdMax(int[] nums) {
//    	int[] a={Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
//        for(int i=0;i<nums.length;i++){
//        	if(nums[i]>a[0]){
//        		a[2]=a[1];
//        		a[1]=a[0];
//        		a[0]=nums[i];
//        	}
//        	else{
//        		if(nums[i]!=a[0]){
//        			 if(nums[i]>a[1]){
//        	        		a[2]=a[1];
//        	        		a[1]=nums[i];
//        				}
//        	        	else {
//        	        		if(nums[i]!=a[1]){
//        	        			if(nums[i]>a[2]){
//                	        		a[2]=nums[i];
//                				}
//        	        		}
//        	        	}
//        		}
//        	}
//        }
//        return a[2];
//    }
	public static int thirdMax(int[] nums) {
		int[] a=new int[3];
		int count=1;
		int beg=0;
		a[0]=nums[0];
		for (int i = 1; i < nums.length; i++) {
			boolean flag=true;
			for(int j=0;j<count;j++){
				if(nums[i]==a[j]){
					flag=false;
					break;
				}
			}
			if(flag){
				a[count]=nums[i];
				count++;
				if(count>=3){
					beg=i+1;
					break;
				}
			}
		}
		if(count==1){
			return a[0];
		}
		else if(count==2){
			return a[0]>a[1]?a[0]:a[1];
		}
		else {
			for(int j=0;j<a.length-1;j++){
				int max=j;
				for (int i = j+1; i < a.length; i++) {
					if(a[i]>a[max]){
						max=i;
					}
				}
				if(max!=j){
				a[max]=a[max]+a[j];
				a[j]=a[max]-a[j];
				a[max]=a[max]-a[j];
				}
			}
	        for(int i=beg;i<nums.length;i++){
        	if(nums[i]>a[0]){
        		a[2]=a[1];
        		a[1]=a[0];
        		a[0]=nums[i];
        	}
        	else{
        		if(nums[i]!=a[0]){
        			 if(nums[i]>a[1]){
        	        		a[2]=a[1];
        	        		a[1]=nums[i];
        				}
        	        	else {
        	        		if(nums[i]!=a[1]){
        	        			if(nums[i]>a[2]){
                	        		a[2]=nums[i];
                				}
        	        		}
        	        	}
        		}
        	}
        }
			return a[2];
		}
	}
}

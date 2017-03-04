package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={0,1,2,4,5,7};
		List<String> result=summaryRanges(a);
		for(String value : result){
			System.out.println(value);
		}
	}
    public static List<String> summaryRanges(int[] nums) {
    	List<String> result=new ArrayList<>();
    	int length=nums.length;
    	if(length==0 || nums==null){
    		return result;
    	}
    	int i=0;
    	int j=1;
    	while(j<length){
    		if(nums[j]-1==nums[j-1]){
    			j++;
    		}
    		else{
    			if(j-i==1){
    				result.add(nums[i]+"");
    			}
    			else{
    				result.add(nums[i]+"->"+nums[j-1]);
    			}
    			i=j;
    			j++;
    		}
    	}
		if(j-i==1){
			result.add(nums[i]+"");
		}
		else{
			result.add(nums[i]+"->"+nums[j-1]);
		}
		i=j;
        return result;
    }
}
 
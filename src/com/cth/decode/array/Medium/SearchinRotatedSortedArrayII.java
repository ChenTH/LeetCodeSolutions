package com.cth.decode.array.Medium;

public class SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,3,1,1,1};
		int b=3;
		System.out.println(search(a,b));
	}

	public static boolean search(int[] nums, int target) {
    	int bef=0;
    	int end=nums.length-1;
    	int mid=0;
    	while(bef<=end){
    		mid=(bef+end)/2;
    		if(nums[mid]==target){
    			return true;
    		}
    		
    		if(nums[bef]>nums[end]){
    			if(nums[mid]>nums[end]){
    				if(nums[mid]>target){
    					if(target>nums[end]){
        					end=mid-1;
    					}
    					else{
    						bef=mid+1;
    					}
    				}
    				else{
    					bef=mid+1;
    				}
    			}
    			else{
    				if(nums[mid]<target){
    					if(target>=nums[bef]){
    						end=mid-1;
    					}
    					else{
    						bef=mid+1;
    					}
    				}
    				else{
    					end=mid-1;
    				}
    			}
    		}
    		else if(nums[bef]==nums[end]){
    			bef++;
    		}
    		else{
    			if(nums[mid]<target){
    				bef=mid+1;
    			}
    			else{
    				end=mid-1;
    			}
    		}
    	}
	return false;
	}
}

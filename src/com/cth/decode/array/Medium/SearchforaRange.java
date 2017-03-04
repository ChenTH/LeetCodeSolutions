package com.cth.decode.array.Medium;

public class SearchforaRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,2};
		int[] b=searchRange(a,2);
		System.out.println(b[0]);
		System.out.println(b[1]);
	}
    public static int[] searchRange(int[] nums, int target) {
    	int[] result={-1,-1};
    	if(nums.length==0){
    		return result;
    	}
    	int begin=0;
    	int end=nums.length-1;
    	int mid=0;
    	while(begin<end){
    		mid=(begin+end)/2;
    		if(nums[mid]<target){
    			begin=mid+1;
    		}
    		else if (nums[mid]>target) {
				end=mid-1;
			}
    		else {
				break;
			}
    	}
    	if(nums[mid]==target){
        	result[0]=findLeft(nums, target, mid);
        	result[1]=findRight(nums, target, mid);
    	}
		return result;
    }
    public static int findLeft(int[] nums, int target,int num){
    	int begin=0;
    	int end=num;
    	while(begin<end){
    		int mid=(begin+end)/2;
    		if(nums[mid]==target){
    			if(mid!=0 && nums[mid-1]==target){
    				end=mid-1;
    			}
    			else {
					return mid;
				}
    		}
    		else if(nums[mid]<target){
    			begin=mid+1;
    		}
    		else {
				end=mid-1;
			}
    	}
    	return 0;
    }
    public static int findRight(int[] nums, int target,int num){
    	int begin=num;
    	int end=nums.length-1;
    	while(begin<end){
    		int mid=(begin+end)/2;
    		if(nums[mid]==target){
    			if(mid!=end && nums[mid+1]==target){
    				begin=mid+1;
    			}
    			else {
					return mid;
				}
    		}
    		else if(nums[mid]<target){
    			begin=mid+1;
    		}
    		else {
				end=mid-1;
			}
    	}
    	return 0;
    }
}

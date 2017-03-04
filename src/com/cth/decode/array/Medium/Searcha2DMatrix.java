package com.cth.decode.array.Medium;

public class Searcha2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] a={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[][] a={{1}};
		searchMatrix(a,3);
	}
    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null){
    		return false;
    	};
    	if(matrix[0][0]>target){
    	    return false;
    	};
    	int row=searchincols(matrix, target);
    	boolean result=searchinrows(matrix, target,row);
		return result;
    }
    public static boolean searchinrows(int[][]matrix,int target,int row){
    	int count=matrix[row].length;
    	int bef=0,end=count-1;
    	while(bef<end){
    		int mid=(bef+end)/2;
    		if(matrix[row][mid]<target){
    			bef=mid+1;
    		}
    		else if(matrix[row][mid]>target){
				end=mid-1;
			}
    		else {
				return true;
			}
    	}
    	if(matrix[row][bef]==target){
    		return true;	
    	}
    	else {
			return false;
		}
    }
    public static int searchincols(int[][]matrix,int target){
    	int count=matrix.length;
    	int bef=0,end=count-1;
    	while(bef<end){
    		int mid=(bef+end)/2;
    		if(matrix[mid][0]<target){
    			bef=mid+1;
    		}
    		else if(matrix[mid][0]>target){
				end=mid-1;
			}
    		else {
				return mid;
			}
    	}
    	if(matrix[bef][0]>target){
    		return bef-1;
    	}
    	else {
			return bef;
		}
    }
}

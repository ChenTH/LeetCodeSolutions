package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] a={};//ø’
//		int[][] a={{1}};//1X1
//		int[][] a={{2,3}};//1X≈º
//		int[][] a={{6,9,7}};//1X∆Ê
//		int[][] a={{7},{9}};//≈ºX1
//		int[][] a={{7},{9},{6}};//∆ÊX1
//		int[][] a={{2,5},{8,4},{0,-1}};//∆ÊX≈º
//		int[][] a={{1,2,3},{8,9,4},{7,6,5}};//∆ÊX∆Ê
//		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12}};//∆ÊX≈º
		int[][] a={{1,2,3},{5,6,7},{9,10,11},{13,14,15}};//≈ºX∆Ê
//		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};//≈ºX≈º
//		int[][] a={{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};//∆ÊX∆Ê
//		int[][] a={{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
		List<Integer> result=spiralOrder(a);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+"   ");
		}
	}
//    public List<Integer> spiralOrder(int[][] matrix) {
//    	List<Integer> result=new ArrayList<>();
//    	if(matrix.length==0){
//    		return result;
//    	}
//    	int rowlen=matrix.length;
//    	int collen=matrix[0].length;
//    	int sprirals=1;
//    	int beg=0;
//    	int count=rowlen*collen;
//    	for(int i=0;i<count;i++){
//    		int rowcount=
//    		result.add();
//    	}
//    }
	public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result=new ArrayList<>();
    	int rowlen=matrix.length;
    	if(rowlen==0){
    		return result;
    	}
    	int collen=matrix[0].length;
    	int row=0;
    	int col=0;
    	while(row<rowlen/2&&col<collen/2){
    		for(int i=col;i<collen-col-1;i++){
    			result.add(matrix[row][i]);
    		}
    		for(int i=row;i<rowlen-row-1;i++){
    			result.add(matrix[i][collen-col-1]);
    		}
    		for(int i=collen-col-1;i>col;i--){
    			result.add(matrix[rowlen-row-1][i]);
    		}
    		for(int i=rowlen-row-1;i>row;i--){
    			result.add(matrix[i][col]);
    		}
    		row++;
    		col++;
    	}
    	if(rowlen-row*2==1||collen-col*2==1){
    		if(rowlen-row*2==1){
    			for (int i = col; i < collen-col; i++) {
					result.add(matrix[row][i]);
				}
    		}
    		else{
    			for(int i=row;i<rowlen-row;i++){
    				result.add(matrix[i][col]);
    			}
    		}
    	}
    	return result;
	}
}

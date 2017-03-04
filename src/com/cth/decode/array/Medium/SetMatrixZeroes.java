package com.cth.decode.array.Medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a={{1,0}};
		setZeroes(a);
	}
    public static void setZeroes(int[][] matrix) {
    	if(matrix==null){
    		return ;
    	}
        Set<Integer> rows=new HashSet<>();
        Set<Integer> cols=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]==0){
        			rows.add(i);
        			cols.add(j);
        		}
        	}
        }
        for(int row : rows){
        	for(int i=0;i<matrix[0].length;i++){
        		matrix[row][i]=0;
        	}
        }
        for(int col : cols){
        	for(int i=0;i<matrix.length;i++){
        		matrix[i][col]=0;
        	}
        }
    }
}

package com.cth.decode.array.Easy;

/**
 * Created by SherlockTHao on 2017/5/14.
 */
public class ReshapetheMatrix {
    public static void main(String[] args){
//        int[][] matrix=new int[2][2];
//        matrix[0][0]=1;
//        matrix[0][1]=2;
//        matrix[1][0]=3;
//        matrix[1][1]=4;
        int[][] matrix=new int[1][4];
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;
        matrix[0][3]=4;
        matrixReshape(matrix,2,2);
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int numsr=nums.length;
        if(numsr<=0){
            return nums;
        }
        int numsc=nums[0].length;
        if(numsr*numsc!=r*c){
            return nums;
        }
        int[][] result=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int a=i*c+j;
                result[i][j]=nums[a/numsc][a%numsc];
            }
        }
        return result;
    }
}

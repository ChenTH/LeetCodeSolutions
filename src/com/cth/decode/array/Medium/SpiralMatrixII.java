package com.cth.decode.array.Medium;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] generateMatrix = generateMatrix(5);
		for (int i = 0; i < generateMatrix.length; i++) {
			for (int j = 0; j < generateMatrix.length; j++) {
				System.out.print(generateMatrix[i][j]+"  ");
			}
			System.out.println();
		}
	}
    public static int[][] generateMatrix(int n) {
    	int[][] matrix=new int[n][n];
    	int a=1;
    	for (int i = 0; i < n/2; i++) {
    		int base=n-2*i-1;
			for (int j = i; j < n-i-1; j++) {
				matrix[i][j]=a;
				matrix[j][n-i-1]=a+base;
				matrix[n-i-1][n-j-1]=a+base*2;
				matrix[n-j-1][i]=a+base*3;
				a++;
			}
			a=a+base*3;
		}
    	if(n%2!=0){
    		matrix[n/2][n/2]=a;
    	}
		return matrix;
    }
}

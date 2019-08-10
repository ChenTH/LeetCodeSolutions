package com.cth.backup.array.Medium;

public class RotateImage {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] a = new int[2][2];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;
        rotate(a);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix2[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - i - 1] = matrix2[i][j];
            }
        }
    }
}

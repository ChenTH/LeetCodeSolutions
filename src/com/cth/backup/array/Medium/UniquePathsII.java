package com.cth.backup.array.Medium;

public class UniquePathsII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] a = new int[col];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        a[0] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    a[j] = 0;
                } else {
                    if (j != 0) {
                        a[j] += a[j - 1];
                    }
                }
            }
        }
        return a[col - 1];
    }
}

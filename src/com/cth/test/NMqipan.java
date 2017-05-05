package com.cth.test;

public class NMqipan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dpSolution());
		System.out.println(dpSolution2());
	}

	public static int dpSolution() {
		int n = 2, m = 4;
		if (n == 0 || m == 0) {
			return 0;
		}
		if (n == 1 || m == 1) {
			if (n == 1) {
				return m - 1;
			} else {
				return n - 1;
			}
		}
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i < m; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[n - 1][m - 1];
	}

	public static int dpSolution2() {
		int n = 2, m = 4;
		if (n == 0 || m == 0) {
			return 0;
		}
		if (n == 1 || m == 1) {
			if (n == 1) {
				return m - 1;
			} else {
				return n - 1;
			}
		}
		int[] dp = new int[m];
		for (int i = 0; i < m; i++) {
			dp[i] = i;
		}
		int row=1;
		while (row<n) {
			dp[0]=row;
			for (int i =1; i < m; i++) {
				dp[i]=dp[i]+dp[i-1];
			}
			row++;
		}
		return dp[m-1];
	}

	public int solution(int m, int n) {
		if (m == 0) {
			return n;
		} else if (n == 0) {
			return m;
		}
		return solution(m - 1, n) + solution(m, n - 1);
	}
}

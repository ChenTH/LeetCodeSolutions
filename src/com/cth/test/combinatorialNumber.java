package com.cth.test;

public class combinatorialNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nCm(4,3));
		System.out.println(DPnCm(4,3));
		System.out.println(DPnCm2(4,3));
	}
	public static int  nCm(int n,int m) {
		if(m==0){
			return 1;
		}
		if(n==0){
			return 0;
		}
		return nCm(n-1, m-1)+nCm(n-1, m);
	}
	public static int DPnCm(int n,int m){
		if(m>n) return -1;
		int[][] dp=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m&&j<=i;j++){
				if(i==0){
					dp[i][j]=1;
				}
				else {
					if(j==0){
						dp[i][j]=i+1;
					}
					else {
						dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
					}
				}
			}
		}
		return dp[n-1][m-1];
	}
	public static int DPnCm2(int n,int m){
		if(m>n) return -1;
		int[] dp=new int[n];
		for(int i=0;i<m;i++){
			for(int j=n-1;j>=i;j--){
				if(i==0){
					dp[j]=1;
				}
				else {
					dp[j]=dp[j-1]+dp[j];
				}
			}
		}
		return dp[n-1];
	}
}

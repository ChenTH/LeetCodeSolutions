package com.cth.decode.array.Medium;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(uniquePaths2(23,12));
	}
    public static int uniquePaths(int m, int n) {
    	return dfs(m,n,1,1);
    }
    public static int dfs(int m, int n,int i, int j){
    	if(i==m && j==n){
    		return 1;
    	}
    	if(i<m && j<n){
    		return dfs(m,n,i+1,j)+dfs(m,n,i,j+1);
    	}
    	else if(i<m){
    		return dfs(m,n,i+1,j);
    	}
    	else{
    		return dfs(m,n,i,j+1);
    	}
    }
    public static int uniquePaths1(int m, int n) {
    	int[][] grid=new int[m][n];
    	for(int i=0;i<m;i++){
    		grid[i][0]=1;
    	}
    	for(int i=0;i<n;i++){
    		grid[0][i]=1;
    	}
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			grid[i][j]=grid[i-1][j]+grid[i][j-1];
    		}
    	}
    	return grid[m-1][n-1];
    }
    public static int uniquePaths2(int m, int n) {
    	int[] a=new int[n];
    	for(int i=0;i<n;i++){
    		a[i]=1;
    	}
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			a[j]+=a[j-1];
    		}
    	}
    	return a[n-1];
    }
}

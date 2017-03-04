package com.cth.decode.hashtable;

public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		islandPerimeter(grid);
	}
    public static int islandPerimeter(int[][] grid) {
    	int perimeter=0;
        for(int i=0;i<grid.length;i++){
        	for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==1){
					if(i==0){
						perimeter++;
					}
					if(i==grid.length-1){
						perimeter++;
					}
					if(j==0){
						perimeter++;
					}
					if(j==grid[0].length-1){
						perimeter++;
					}
					if(i!=0) { 
						if(grid[i-1][j]!=1){
							perimeter++;
						}
					};
					if(i!=grid.length-1){ 
						if(grid[i+1][j]!=1) {
							perimeter++;
						}
					};
					if(j!=0){
						if(grid[i][j-1]!=1){
							perimeter++;
						}
					};
					if(j!=grid[0].length-1){
						if(grid[i][j+1]!=1){
							perimeter++;
						}
					}
				}
			}
        }
        return perimeter;
    }
}

package com.cth.decode.array.Medium;

public class GameofLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a=new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				a[i][j]=0;
			}
		}
		a[1][2]=1;
		a[2][2]=1;
		a[3][2]=1;
		gameOfLife(a);
		for (int[] is : a) {
			for (int i : is) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
    public static void gameOfLife(int[][] board) {
    	int rowlength=board.length;
		if(rowlength==0){
			return ;
		}
    	int collength=board[0].length;
        for(int i=0;i<rowlength;i++){
        	for(int j=0;j<collength;j++){
        		int livecount=0;
        		for(int k=i-1;k<=i+1;k++){//遍历周围八个点
        			for(int l=j-1;l<=j+1;l++){
        				if(!(k==i&&l==j)){
        					if(k>=0 && k<rowlength && l>=0 && l<collength){
        						if(board[k][l]==1||board[k][l]==2){
            						livecount++;
        						}
        					}
        				}
        			}
        		}
    			if(board[i][j]==1){//0死到死1生到生2生到死3死到生
    				if(livecount<2){
    					board[i][j]=2;
    				}
    				else if(3<livecount){
    					board[i][j]=2;
    				}
    			}
    			else{
    				if(livecount==3){
    					board[i][j]=3;
    				}
    			}
        	}
        }
        for(int i=0;i<rowlength;i++){
        	for(int j=0;j<collength;j++){
        		board[i][j]=board[i][j]%2;
        	}
        }
    }
}

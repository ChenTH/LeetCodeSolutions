package com.cth.decode.array.Medium;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word="SEE";
//		char[][] board={{'A'}};
//		String word="A";
//		char[][] board={
//				{'A','A','A','A'},
//				{'A','A','A','A'},
//				{'A','A','A','A'}
//		};
//		String word="AAAAAAAAAAAAA";
		boolean result=exist(board,word);
		System.out.println(result);
	}
    public static boolean exist(char[][] board, String word) {
    	if(board.length==0){
    		return false;
    	}
    	char[] wordarray=word.toCharArray();
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(board[i][j]==wordarray[0]){
    		    	boolean[][] flag=new boolean[board.length][board[0].length];
    				if(dfs(board, wordarray, i, j, flag,0)){
    					return true;
    				};
    			}
    		}
    	}
        return false;
    }
    public static boolean dfs(char[][] board, char[] wordarray,int row,int col,boolean[][] flag,int count) {
    	boolean result=false;
    	boolean a=false;
    	if(flag[row][col]!=true){
    		flag[row][col]=true;
    		a=true;
			if(wordarray[count]==board[row][col]){
				if(count+1==wordarray.length){
					result = true;
				}
				else {
					boolean down=false,up=false,left=false,right=false;
	    			 down=col+1 < board[0].length ?  dfs(board, wordarray, row, col+1, flag, count+1) : false;
	    			if(!down){
		    			 up=col-1>=0 ? dfs(board, wordarray, row, col-1, flag, count+1) : false;
		    			if(!up){
			    			 left=row-1>=0 ? dfs(board, wordarray, row-1, col, flag, count+1) : false;
			    			if(!left){
				    			 right=row+1 < board.length?dfs(board, wordarray, row+1, col, flag, count+1):false;
			    			}
		    			}
	    			}
	    			result = up||down||left||right;
				}
    		}
    		else {
    			result = false;
			}
    	}
    	else{
    		result = false;
    	}
    	if(!result&&a){
    		flag[row][col]=false;
    	}
    	return result;
	}
}

package com.cth.decode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] a={
				{'.','.','5','.','.','.','.','.','6'},
				{'.','.','.','.','1','4','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','9','2','.','.'},
				{'5','.','.','.','.','2','.','.','.'},
				{'.','.','.','.','.','.','.','3','.'},
				{'.','.','.','5','4','.','.','.','.'},
				{'3','.','.','.','.','.','4','2','.'},
				{'.','.','.','2','7','.','6','.','.'}
		};
		boolean b=isValidSudoku(a);
		System.out.println(b);
	}
    public static boolean isValidSudoku(char[][] board) {
    	ArrayList<Set<Character>> arrayList=new ArrayList<Set<Character>>();
    	for(int i=0;i<9;i++){
        	Set<Character> set=new HashSet<Character>();
        	arrayList.add(set);
    	}//计算小方格
    	for(int i=0;i<9;i++){
    		Set<Character> setcol=new HashSet<Character>();
    		Set<Character> setrow=new HashSet<Character>();
    		for(int j=0;j<9;j++){
    			if(board[i][j]!='.'){
    				if(setcol.contains(board[i][j])){
    					return false;
    				}
    				else {
    					setcol.add(board[i][j]);
					}
    			}//行
    			if(board[j][i]!='.'){
    				if(setrow.contains(board[j][i])){
    					return false;
    				}
    				else {
    					setrow.add(board[j][i]);
					}
    			}//列
    			if(board[i][j]!='.'){
    				Set<Character> set=arrayList.get(i/3*3+j/3);
    				if(set.contains(board[i][j])){
    					return false;
    				}
    				else {
						set.add(board[i][j]);
					}
    			}//方块
    		}
    	}
		return true;
    }
}

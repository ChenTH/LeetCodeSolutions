package com.cth.test;

import java.util.Scanner;

public class evenbunch {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        char[] chars=n.toCharArray();
        if(chars.length==0){
        	return;
        }
        int [][] ints=new int[n.length()+1][26];
        for(int i=1;i<n.length()+1;i++){
        	for(int j=0;j<26;j++){
        		ints[i][j]=ints[i-1][j];
        	}
        	ints[i][chars[i-1]-'a']++;
        }
        int result=0;
        for(int i=1;i<n.length();i++){
        	result+=caunteven(ints,i);
        }
        System.out.print(result);
	}
	public static int caunteven(int[][] ints,int i){
		int bef=0;
		int end=bef+i;
		int count=0;
		while (end<ints.length) {
			boolean flag=true;
			for(int j=0;j<26;j++){
				if((ints[end][j]-ints[bef][j])%2!=0){
					flag=false;
					break;
				}
			}
			if(flag){
				count++;
			}
			bef++;
			end++;
		}
		return count;
	}
}

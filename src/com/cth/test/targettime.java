package com.cth.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class targettime {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] taskList = new int[n];
        int[] resultList=new int[m];
        List<Integer> slie=new ArrayList<>();
        for(int i=0;i<n;i++){
        	taskList[i]=in.nextInt();
        }
        for(int i=1;i<n;i++){
        	if(taskList[i]-taskList[i-1]!=1){
        		slie.add(taskList[i-1]+1);
        	}
        }
		slie.add(taskList[n-1]+1);
        for(int i=0;i<m;i++){
        	int temp=in.nextInt();
        	for(Integer num : slie){
        		if(num>=temp){
        			resultList[i]=num;
        			break;
        		}
        	}
        }
        for(int i=0;i<m;i++){
        	System.out.println(resultList[i]);
        }
	}
}

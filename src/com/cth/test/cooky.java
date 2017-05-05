package com.cth.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class cooky {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        char[] a=n.toCharArray();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<a.length;i++){
        	if(a[i]=='X'){
        		list.add(i);
        	}
        }
        int res=0;
        int num1=1;
        int size=list.size();
        for(int i=0;i<size;i++){
        	num1*=10;
        }
        for(int i=0;i<num1;i++){
        	int num2=i;
        	for(int j=0;j<size;j++){
        		int c=num2%10;
        		a[list.get(size-j-1)]=(char) (num2%10+'0');
        		num2=num2/10;
        	}
        	if(judgeNum(a,k)){
        		res++;
        	}
        }
        System.out.print(res);
    }
    public static boolean judgeNum(char[] a,int n) {
    	String string=new String(a);
		BigInteger bigInteger=new BigInteger(string);
		BigInteger bigInteger2=new BigInteger(n+"");
		BigInteger zero=new BigInteger(0+"");
		if(bigInteger.mod(bigInteger2).equals(zero)){
			return true;
		}
		else {
			return false;
		}
	}
}

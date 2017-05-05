package com.cth.test;

import java.math.BigInteger;
import java.util.Scanner;
public class band {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] res=new int[n];
//        for(int i=0;i<n;i++){
//        	res[i]=in.nextInt();
//        }
//        for(int i=0;i<k;i++){
//        	int[] res2=new int[n];
//            for(int j=0;j<n;j++){
//            	if(j!=n-1){
//                	res2[j]=(res[j]+res[j+1])%100;
//            	}
//            	else {
//            		res2[j]=(res[j]+res[0])%100;
//				}
//            }
//            res=res2;
//        }
//        for(int j=0;j<n-1;j++){
//        	System.out.print(res[j]+" ");
//        }
//    	System.out.print(res[n-1]);
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
        	res[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
        }
        for(int j=0;j<n-1;j++){
        	System.out.print(res[j]+" ");
        }
    	System.out.print(res[n-1]);
    }
}

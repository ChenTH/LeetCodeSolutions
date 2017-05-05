package com.cth.test;

import java.util.Scanner;

public class gete {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] ra=new int[n][2];
        for(int i=0;i<n;i++){
        	ra[i][0]=in.nextInt();
        	ra[i][1]=in.nextInt();
        }
        double e=0;
        for(int i=0;i<n;i++){
        	e+=ra[i][0]*ra[i][1]/100.0;
        }
        java.text.NumberFormat  formater  =  java.text.DecimalFormat.getInstance();  
        formater.setMaximumFractionDigits(3);  
        formater.setMinimumFractionDigits(3);  
        System.out.println(formater.format(e));
	}
}

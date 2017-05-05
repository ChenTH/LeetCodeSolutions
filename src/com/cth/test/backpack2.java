package com.cth.test;

import java.util.Scanner;

public class backpack2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		int[] val = new int[count];
		int[] weight = new int[count];
		int[] num=new int[count];
		for (int i = 0; i < count; i++) {
			val[i] = in.nextInt();
		}
		for (int i = 0; i < count; i++) {
			weight[i] = in.nextInt();
		}
		int sum=in.nextInt();
		int[] f = new int[sum + 1];
		for (int i = 0; i < count; i++) {
			for (int j = sum; j >= weight[i]; j--) {
				for (int k = 1; k < num[i]; k++) {
					if(k*num[i]<j){
						f[j] = Math.max(f[j], f[j - weight[i]] + val[i]);
					}
					else {
						break;
					}
				}
			}
		}
		System.out.println(f[sum]);
	}
}

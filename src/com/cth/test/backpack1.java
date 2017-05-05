package com.cth.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class backpack1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String aString=in.nextLine();
		int sum=in.nextInt();
		String[] bStrings=aString.split(",");
		int length=bStrings.length;
		int[] weight = new int[bStrings.length];
		int[] val = new int[bStrings.length];
		for (int i = 0; i < bStrings.length; i++) {
			weight[i]=Integer.parseInt(bStrings[i]);
		}
		for (int i = 0; i < bStrings.length; i++) {
			val[i]=1;
		}
		int[] f = new int[sum + 1];
		int result=Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			for (int j = weight[i]; j <=sum; j++) {
				f[j] = Math.max(f[j], f[j - weight[i]] + val[i]);
			}
			if(f[sum]<result){
				result=f[sum];
			}
		}
		System.out.println(result);
	}
}

package com.cth.test;

public class backpack {
	public static void main(String[] args) {
//		int v=10;
//		int [] a={1,2,3,4,5,6,7,8,9,10};
//		int [] b={1,2,3,4,5,6,7,8,9,10};
//		int [] back=new int [v];
//		for (int i = 0; i < back.length; i++) {
//			System.out.println(back[i]);
//		}
		String str1=new String("Demo");
		String str2="Demo";
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.intern()==str2);
		System.out.println(str1.intern()==str1);
	}
	public void solution(int[] a,Integer [] b,int v,int back[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < v; j++) {
				back[j]=Math.max(back[j], back[j-a[i]]+b[i]);
			}
		}
	}
	public void solution2(int[] a,Integer [] b,int v,int back[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < v; j++) {
				back[j]=Math.max(back[j], back[j-a[i]]+b[i]);
			}
		}
	}
}

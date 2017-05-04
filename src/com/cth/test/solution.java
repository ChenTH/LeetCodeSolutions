package com.cth.test;


public class solution {
	public static void main(String[] args) {
		int[] a={0,0,0};
		int[] b={0,0,5};
		int[] c={0,5,0};
		System.out.println(calculateArea(a,b,c));
	}
	public static  String calculateArea(int[] a,int[] b,int[] c) {
		double ab=calculateLength(a, b);
		double bc=calculateLength(b, c);
		double ac=calculateLength(a, c);
		double p=(ab+bc+ac)/2;
//		return Math.sqrt(p*(p-ab)*(p-bc)*(p-ac))
		java.text.DecimalFormat   df=new  java.text.DecimalFormat("0.00000");
		return df.format(Math.sqrt(p*(p-ab)*(p-bc)*(p-ac)));
	}
	public static double calculateLength(int[] a,int[] b) {	
		int temp=0;
		for(int i=0;i<a.length;i++){
			temp+=Math.pow((a[i]-b[i]),2);
		}
		return Math.sqrt(temp);
	}
}

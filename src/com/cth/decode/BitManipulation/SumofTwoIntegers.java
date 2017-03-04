package com.cth.decode.BitManipulation;

public class SumofTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		int b=1;
		System.out.println(getSum(a,b));
	}
    public static int getSum(int a, int b) {
    	while (b!=0) {
    		int c=a^b;
    		int d=a&b;
    		b=d<<1;
    		a=c;
		}
		return a;
    }
}

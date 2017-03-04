package com.cth.test;

import java.math.BigInteger;

public class bigintegertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger a=BigInteger.valueOf(1);
			a=a.multiply(BigInteger.valueOf(100));
			System.out.println(a);
			a=a.subtract(BigInteger.valueOf(10));
			System.out.println(a);
			String string=a.toString();
			System.out.println(string);
			int b=Integer.parseInt(string);
			System.out.println(b);
	}

}

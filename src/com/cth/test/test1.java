package com.cth.test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class test1 {
	public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String aString=in.nextLine();
        char[] achar=aString.toCharArray();
        for(int i=0;i<achar.length;i=i+16){
        	StringBuffer sBuffer=new StringBuffer();
        	String hexStr=Long.toHexString(i);
        	int length=hexStr.length();
        	while (8-length>0) {
        		sBuffer.append('0');
        		length++;
			}
        	sBuffer.append(hexStr);
        	System.out.print(sBuffer+"  ");
        	for(int j=0;j<8;j++){
        		System.out.print(Long.toHexString(achar[i+j])+" ");
        	}
        	System.out.print(" ");
        	for(int j=8;j<16;j++){
        		System.out.print(Long.toHexString(achar[i+j])+" ");
        	}
        	System.out.print(" ");
        	for(int j=0;j<16;j++){
        		System.out.print(achar[i+j]);
        	}
        	System.out.println();
        }
	}
}

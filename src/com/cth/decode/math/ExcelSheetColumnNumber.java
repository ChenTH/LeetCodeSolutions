package com.cth.decode.math;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int titleToNumber(String s) {
    	char[] arr=s.toCharArray();
    	int num=0;
    	int rad=1;
    	int length=arr.length;
    	for(int i=length-1;i>=0;i--){
    		int a=arr[i]-64;
    		num=num+a*rad;
    		rad=rad*26;
    	}
		return num;
    }
}

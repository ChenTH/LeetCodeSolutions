package com.cth.decode.math.Easy;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String convertToTitle(int n) {
    	String result="";
    	while(n!=0){
    		int a=(n-1)%26;
    		n=n/26;
    		result=(char)(a+65)+result;
    	}
		return result;
    }
}

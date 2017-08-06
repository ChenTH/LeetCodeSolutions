package com.cth.decode.math.Easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(int x) {
    	if(x<0){
    		return false;
    	}
    	if(x==0){
    		return true;
    	}
    	int length=String.valueOf(x).length();
    	int b=(int) Math.pow(10,length-1);
    	while(x!=0){
    		int bef=x/b;
    		int las=x%10;
    		if(bef!=las){
    			return false;
    		}
    		x=x-bef*b;
    		b=b/100;
    		x=x/10;
    	}
    	return true;
    }
}

package com.cth.decode.math;

public class AddStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String len1="1";
		String len2="9";
		addStrings(len1,len2);
	}
    public static String addStrings(String num1, String num2) {
        StringBuffer stringBuffer=new StringBuffer();
        int len1=num1.length()-1;
        int len2=num2.length()-1;
        char[] char1=num1.toCharArray();
        char[] char2=num2.toCharArray();
        int remain=0;
        while (len1>-1 || len2>-1) {
        	int c1='0';
        	int c2='0';
        	if(len1>-1){
        		c1=char1[len1];
        	}
        	if(len2>-1){
        		c2=char2[len2];
        	}
        	int result=(c1-'0')+(c2-'0')+remain;
        	remain=result/10;
        	stringBuffer.insert(0, (char)(result%10+'0'));
        	len1--;
        	len2--;
		}
        if(remain!=0){
        	stringBuffer.insert(0, (char)(remain+'0'));
        }
        return stringBuffer.toString();
    }
}

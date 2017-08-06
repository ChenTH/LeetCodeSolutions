package com.cth.decode.TwoPointers.Easy;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="hello";
		System.out.println(reverseString(string));
	}
	 public static String reverseString(String s) {
	        if(s == null) return null;
	        if(s.equals("")) return s;
	        int length=s.length();
		 char[] ss=new char[s.length()];
	        for(int i=0;i<length/2;i++){
	            ss[i]=s.charAt(length-i-1);
	            ss[length-i-1]=s.charAt(i);
	        }
	        if(length%2==1){
	        	ss[length/2]=s.charAt(length/2);
	        }
		return new String(ss);
	 }
}

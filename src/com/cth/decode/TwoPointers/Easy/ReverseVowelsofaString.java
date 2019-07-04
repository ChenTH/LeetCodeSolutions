package com.cth.decode.TwoPointers.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ReverseVowelsofaString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String string = "leetcode";
        System.out.println(reverseVowels(string));
    }

    //    public static String reverseVowels(String s) {//反转相邻的
//    	if(s==null || s.length()==0){return s;};
//    	ArrayList<Character> arr=new ArrayList<>();
//    	int a=-1;
//    	char b;
//    	do {
//        	a++;
//        	b=s.charAt(a);
//        	arr.add(b);
//		} while ((!isVowels(b))&&(a<s.length()-1));
//    	
//    	for(int i=a+1;i<s.length();i++){
//    		char now=s.charAt(i);
//    		if(isVowels(now)){
//    			arr.add(arr.get(a));
//    			arr.set(a, now);
//    			a=i;
//    		}
//    		else {
//				arr.add(now);
//			}
//    	}
//    	String result="";
//    	for(int i=0;i<arr.size();i++){
//    		result=result+arr.get(i);
//    	}
//    	
//		return result;
//    }
//	 public static String reverseVowels(String s) {//简单做法
//		 if(s==null || s.length()==0){return s;};
//		 Stack<Integer> stack=new Stack<>();
//		 for(int i=0;i<s.length();i++){
//			 if(isVowels(s.charAt(i))){
//				 stack.push(i);
//			 }
//		 }
//		 String result="";
//		 for(int i=0;i<s.length();i++){
//			 if(isVowels(s.charAt(i))){
//				 result=result+s.charAt(stack.pop());
//			 }
//			 else {
//				result=result+s.charAt(i);
//			}
//		 }
//		return result;
//	 }
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        ;
        //HashMap<Integer, Character> map=new HashMap<>();
        int bef = 0;
        int last = s.length() - 1;
        char[] ss = new char[s.length()];
        while (true) {
            for (int i = bef; i <= last; i++) {
                bef = i;
                if (isVowels(s.charAt(i))) {
                    break;
                } else {
                    ss[i] = s.charAt(i);
                    //map.put(i, s.charAt(i));
                }
            }
            for (int i = last; i >= bef; i--) {
                last = i;
                if (isVowels(s.charAt(i))) {
                    break;
                } else {
                    ss[i] = s.charAt(i);
                    //map.put(i, s.charAt(i));
                }
            }
            if (bef < last) {
                ss[bef] = s.charAt(last);
                ss[last] = s.charAt(bef);
                //map.put(bef, s.charAt(last));
                //map.put(last, s.charAt(bef));
                bef = bef + 1;
                last = last - 1;
            } else if (bef == last) {
                ss[bef] = s.charAt(bef);
                //map.put(bef, s.charAt(bef));
                break;
            } else {
                break;
            }
        }
//		 String result="";
//		 for(int i=0;i<s.length();i++){
//			 result=result+map.get(i);
//		 }
//		 for(int i=0;i<s.length();i++){
//		 result=result+map.get(i);
//	 }
//		 StringBuilder sBuilder=new StringBuilder();
//		 for(int i=0;i<s.length();i++){
//		 sBuilder.append(map.get(i));
//		 }
        return new String(ss);
    }

    public static boolean isVowels(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
            return true;
        }
        return false;

    }
}

package com.cth.decode.hashtable.Easy;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.CDATASection;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString="abccccdd";
		longestPalindrome(aString);
	}
//    public static int longestPalindrome(String s) {
//    	int result=0;
//    	char[] cs=s.toCharArray();
//    	for(int i=0;i<s.length();i++){
//    		int bef=i,end=i;
//    		while(cs[bef]==cs[end]){
//    			if(bef==0){
//    				break;
//    			}
//    			if(end==cs.length-1){
//    				break;
//    			}
//				bef--;
//				end++;
//    		}
//    		if(end-bef+1>result){
//    			result=end-bef+1;
//    		}
//    	}
//    	return result;
//    }
	public static int longestPalindrome(String s) {
    	int result=0;
		char[] cs=s.toCharArray();
		Map<Character, Integer> map=new HashMap<>();
		for(int i=0;i<cs.length;i++){
			if(map.containsKey(cs[i])){
				map.put(cs[i], map.get(cs[i])+1);
			}
			else {
				map.put(cs[i], 1);
			}
		}
		boolean odd=false;
		for(char key : map.keySet()){
			result+=map.get(key)/2;
			if(map.get(key)%2==1){
				odd=true;
			}
		}
		result*=2;
		if(odd){
			result++;
		}
		return result;
	}
}

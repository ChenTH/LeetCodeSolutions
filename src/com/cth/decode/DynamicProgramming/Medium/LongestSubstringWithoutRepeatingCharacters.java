package com.cth.decode.DynamicProgramming.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String aString="abba";
		String aString="abcabcbb";
		lengthOfLongestSubstring(aString);
		lengthOfLongestSubstring2(aString);
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s.length()==0) return 0;
    	int[] dp=new int[s.length()];
    	dp[0]=1;
    	int i,j,max=1,maxindex=0;
    	for(i=1;i<s.length();i++){
    		for(j=i-1;j>i-1-dp[i-1];j--){
    			if(s.charAt(i)==s.charAt(j)){
    				dp[i]=i-j;
    				break;
    			}
    		}
    		if(j==i-1-dp[i-1]){
    			dp[i]=dp[i-1]+1;
    		}
    		if(dp[i]>max){
    			max=dp[i];
    			maxindex=i-max+1;
    		}
    	}
		System.out.println(s.substring(maxindex, maxindex+max));
		return max;
    }
	public static int lengthOfLongestSubstring2(String s) {
		if(s.length()==0) return 0;
    	int dp=1;
    	int i,j,max=1,maxindex=0;
    	for(i=1;i<s.length();i++){
    		int tmp=i-1-dp;
    		for(j=i-1;j>tmp;j--){
    			if(s.charAt(i)==s.charAt(j)){
    				dp=i-j;
    				break;
    			}
    		}
    		if(j==tmp){
    			dp=dp+1;
    		}
    		if(dp>max){
    			max=dp;
    			maxindex=i-max+1;
    		}
    	}
		System.out.println(s.substring(maxindex, maxindex+max));
		return max;
    }
}

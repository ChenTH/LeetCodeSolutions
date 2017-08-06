package com.cth.decode.TwoPointers.Easy;

public class PermutationinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString="ab";
		String bString="eidbaooo";
		System.out.println(checkInclusion(aString,bString));
		System.out.println(checkInclusion2(aString,bString));
	}

	public static boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length()) {
			return false;
		}
		int[] s1Counts = new int[26];
		int[] s2Counts = new int[26];
		for (int i = 0; i < 26; i++) {
			s2Counts[i] = 0;
			s1Counts[i] = 0;
		}
		for (int i = 0; i < s1.length(); i++) {
			s1Counts[s1.charAt(i) - 'a']++;
			s2Counts[s2.charAt(i) - 'a']++;
		}
		int low = 0, high = s1.length() - 1;
		while (true) {
			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (s1Counts[i] != s2Counts[i]) {
					flag = false;
					break;
				}
			}
			if(flag){
				return true;
			}
			else {
				if(high<s2.length()-1){
					s2Counts[s2.charAt(low++)-'a']--;
					s2Counts[s2.charAt(++high)-'a']++;
				}
				else {
					break;
				}
			}
		}
		return false;
	}
	public static boolean checkInclusion2(String s1, String s2) {
		if (s2.length() < s1.length()) {
			return false;
		}
		int[] counts = new int[26];
		for (int i = 0; i < 26; i++) {
			counts[i] = 0;
		}
		for (int i = 0; i < s1.length(); i++) {
			counts[s1.charAt(i) - 'a']--;
			counts[s2.charAt(i) - 'a']++;
		}
		int low = 0, high = s1.length() - 1;
		while (true) {
			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (counts[i] != 0) {
					flag = false;
					break;
				}
			}
			if(flag){
				return true;
			}
			else {
				if(high<s2.length()-1){
					counts[s2.charAt(low++)-'a']--;
					counts[s2.charAt(++high)-'a']++;
				}
				else {
					break;
				}
			}
		}
		return false;
	}
}

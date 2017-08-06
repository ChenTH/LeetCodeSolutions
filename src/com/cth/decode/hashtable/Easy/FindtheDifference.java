package com.cth.decode.hashtable.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindtheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public char findTheDifference(String s, String t) {
    	int[] a=new int[26];
    	for (char b : s.toCharArray()) {
			a[b-97]++;
		}
    	for (char b : t.toCharArray()) {
			if(--(a[b-97])<0){
				return b;
			}
		}
		return 0;
    }
}

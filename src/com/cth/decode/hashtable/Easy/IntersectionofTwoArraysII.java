package com.cth.decode.hashtable.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionofTwoArraysII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,2,1};
		int[] b={2,2};
		int[] c=intersect(a,b);
		for(int i=0;i<c.length;i++){
			System.out.println(c[i]);
		}
	}
	public static int[] intersect(int[] nums1, int[] nums2) {
    ArrayList<Integer> array=new ArrayList<>();
    HashMap<Integer, Integer> map1=new HashMap<>();
    HashMap<Integer, Integer> map2=new HashMap<>();
	for(int i=0;i<nums1.length;i++){
		if(map1.containsKey(nums1[i])){
			map1.put(nums1[i], map1.get(nums1[i])+1);
		}
		else {
			map1.put(nums1[i], 1);
		}
	}
	for(int i=0;i<nums2.length;i++){
		if(map1.containsKey(nums2[i])){
			if(map2.containsKey(nums2[i])){
				map2.put(nums2[i], map2.get(nums2[i])+1);
			}
			else {
				map2.put(nums2[i], 1);
			}
		}
	}
	for(int num:map2.keySet()){
		int count=map2.get(num);
		if(map1.get(num)<map2.get(num)){
			count=map1.get(num);
		}
		for(int j=0;j<count;j++){
			array.add(num);
		}
	}
	int[] result=new int[array.size()];
	for(int i=0;i<array.size();i++){
		result[i]=array.get(i);
	}
	return result;
}
}

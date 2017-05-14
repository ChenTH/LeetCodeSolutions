package com.cth.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Problem1 {
	public static void main(String[] args){
		HashMap<Integer, Integer> map=new HashMap<>();
		map.put(1, 1);
		Hashtable<Integer, Integer> table=new Hashtable<>();
		table.put(1, 1);
		Set<Integer> set=new HashSet<>();
		set.add(1);
		ConcurrentHashMap<Integer, Integer> cMap=new ConcurrentHashMap<>();
		cMap.put(1,1);
	}
}

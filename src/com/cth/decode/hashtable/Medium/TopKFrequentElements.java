package com.cth.decode.hashtable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map=new HashMap<>();
    	List<Integer> list = new ArrayList<>();
    	for(int num : nums){
    		if(map.containsKey(num)){
    			map.put(num, map.get(num)+1);
    		}
    		else {
				map.put(num, 1);
			}
    	}
    	for(int i=0;i<k;i++) {
    		int count=0;
    		int tar = 0;
    		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  
    			if(entry.getValue()>count){
    				count=entry.getValue();
    				tar=entry.getKey();
    			}
    		}
    		list.add(tar);
    		map.remove(tar);
		}
    	return list;
    }
}

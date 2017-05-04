package com.cth.decode.hashtable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 6, 6, 7, 7, 4, 4 };
		topKFrequent(nums, 2);
	}
	// public static List<Integer> topKFrequent(int[] nums, int k) {
	// Map<Integer, Integer> map=new HashMap<>();
	// List<Integer> list = new ArrayList<>();
	// for(int num : nums){
	// if(map.containsKey(num)){
	// map.put(num, map.get(num)+1);
	// }
	// else {
	// map.put(num, 1);
	// }
	// }
	// for(int i=0;i<k;i++) {
	// int count=0;
	// int tar = 0;
	// for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	// if(entry.getValue()>count){
	// count=entry.getValue();
	// tar=entry.getKey();
	// }
	// }
	// list.add(tar);
	// map.remove(tar);
	// }
	// return list;

	// }
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
}

package com.cth.decode.hashtable.Easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberofBoomerangs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int numberOfBoomerangs(int[][] points) {
    	int result=0;
    	for (int i = 0; i < points.length; i++) {
			int x=points[i][0];
			int y=points[i][1];
			Map<Long, Integer> map=new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				int x1=points[j][0];
				int y1=points[j][1];
				long dist = (x1 - x)*(x1 - x) + (y1-y)*(y1-y);  
				if(map.containsKey(dist)){
					map.put(dist, map.get(dist)+1);
				}
				else {
					map.put(dist, 1);
				}
			}
	        for(Map.Entry<Long, Integer> entry:map.entrySet()){ 
                int val = entry.getValue();  
                
                result += val *(val-1);  
	        }
		}
    	return result;
    }
}

package com.cth.decode.array.Medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
	Set<Integer> set=new HashSet<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(set.contains(val)){
			return false;
    	}
    	else{
    		set.add(val);
    		return true;
    	}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(set.contains(val)){
    		set.remove(val);
    		return true;
    	}
    	else{
			return false;
    	}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random ra =new Random();
    	int a=ra.nextInt(set.size());
    	Iterator<Integer>it=set.iterator();
    	for (int i = 0; i < a; i++) {
    		it.next();
		}
    	return (Integer)it.next();
    }
}


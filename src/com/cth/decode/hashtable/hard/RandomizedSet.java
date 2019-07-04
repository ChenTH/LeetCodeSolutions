package com.cth.decode.hashtable.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    Map<Integer, Integer> map = null;
    List<Integer> list = null;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean flag = map.containsKey(val);
        if (!flag) {
            list.add(val);
            map.put(val, list.size() - 1);
        }
        return !flag;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean flag = map.containsKey(val);
        if (flag) {
            int size = list.size();
            int last = list.get(size - 1);
            list.set(map.get(val), last);
            map.put(last, map.get(val));
            list.remove(size - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        java.util.Random rand = new java.util.Random();
        return list.get(rand.nextInt(list.size()));
    }
}

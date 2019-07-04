package com.cth.decode.hashtable.Easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        if (set.size() > candies.length / 2) {
            return candies.length / 2;
        } else {
            return set.size();
        }
    }
}

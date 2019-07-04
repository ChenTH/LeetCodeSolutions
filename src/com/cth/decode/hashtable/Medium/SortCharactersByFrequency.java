package com.cth.decode.hashtable.Medium;

import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "tree";
        frequencySort(a);
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        while (map.size() != 0) {
            int count = 0;
            Character tar = null;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > count) {
                    count = entry.getValue();
                    tar = entry.getKey();
                }
            }
            for (int i = 0; i < count; i++) {
                str.append(tar);
            }
            map.remove(tar);
        }
        return str.toString();
    }
}

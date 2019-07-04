package com.cth.decode.hashtable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String string = "AAAAAAAAAAA";
        findRepeatedDnaSequences(string);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= length - 10; i++) {
            String aString = s.substring(i, i + 10);
            if (map.containsKey(aString)) {
                map.put(aString, map.get(aString) + 1);
            } else {
                map.put(aString, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        Set<String> words = new HashSet<>();
        Set<String> doubleWords = new HashSet<>();
        List<String> resule = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i <= length - 10; i++) {
            String aString = s.substring(i, i + 10);
            if (!words.add(aString) && doubleWords.add(aString)) {
                resule.add(aString);
            }
        }
        return resule;
    }
}

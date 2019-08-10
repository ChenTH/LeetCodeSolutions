package com.cth.backup.hashtable.Easy;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "ab";
        String b = "aa";
        boolean c = isIsomorphic(a, b);
        System.out.println(c);
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (set.contains(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}

package com.cth.decode.hashtable.Easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        char[] jchars = J.toCharArray();
        char[] schars = S.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        for (char c : jchars) {
            set.add(c);
        }
        for (char c : schars) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}

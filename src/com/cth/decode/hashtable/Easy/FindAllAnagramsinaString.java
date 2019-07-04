package com.cth.decode.hashtable.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams(s, p);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        char[] cp = p.toCharArray();
        char[] cs = s.toCharArray();
        int[] pcount = new int[26];
        int[] scount = new int[26];
        for (int i = 0; i < scount.length; i++) {
            pcount[i] = 0;
            scount[i] = 0;
        }
        for (int i = 0; i < cp.length; i++) {
            pcount[cp[i] - 'a']++;
        }
        for (int i = 0; i < cp.length; i++) {
            scount[cs[i] - 'a']++;
        }
        if (compareMap(pcount, scount)) {
            result.add(0);
        }
        for (int i = cp.length; i < cs.length; i++) {
            scount[cs[i] - 'a']++;
            scount[cs[i - cp.length] - 'a']--;
            if (compareMap(pcount, scount)) {
                result.add(i - cp.length + 1);
            }
        }
        return result;
    }

    public static boolean compareMap(int[] cp, int[] sp) {
        for (int i = 0; i < 26; i++) {
            if (cp[i] - 'a' != sp[i] - 'a') {
                return false;
            }
        }
        return true;
    }
}

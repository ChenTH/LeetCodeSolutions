package com.cth.backup.TwoPointers.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SherlockTHao on 2017/5/17.
 */
public class LongestWordinDictionarythroughDeleting {
    public static void main(String[] args) {
        String s = "bab";
        List<String> list = new ArrayList<String>();
        list.add("ba");
        list.add("ab");
        list.add("a");
        list.add("b");
        System.out.print(findLongestWord(s, list));
    }

    public static String findLongestWord(String s, List<String> d) {
        String res = "";
        int length = 0;
        for (int i = 0; i < d.size(); i++) {
            String t = d.get(i);
            if (t.length() >= length) {
                if (fitWord(s, t)) {
                    if (t.length() > length) {
                        length = t.length();
                        res = t;
                    } else {
                        res = compWord(res, t);
                    }
                }
            }
        }
        return res;
    }

    public static boolean fitWord(String s, String t) {
        if (t.length() > s.length()) return false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == t.length()) return true;
        else return false;
    }

    public static String compWord(String a, String b) {
        if (a == b) return a;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return b;
            } else if (a.charAt(i) < b.charAt(i)) {
                return a;
            }
        }
        return a;
    }
}

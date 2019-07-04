package com.cth.decode.math.Medium;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsfromEnglish {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "towoen";
        System.out.println(originalDigits(a));
    }

    public static String originalDigits(String s) {
        int[] count = new int[26];
        Map<Integer, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] index = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        String[] num = {"zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"};
        char[] cs = {'z', 'w', 'u', 'x', 'g', 'o', 'h', 'f', 's', 'i'};
        for (int i = 0; i < cs.length; i++) {
            if (count[cs[i] - 'a'] != 0) {
                int numc = count[cs[i] - 'a'];
                result.put(index[i], numc);
                char[] nc = num[i].toCharArray();
                for (int j = 0; j < nc.length; j++) {
                    count[nc[j] - 'a'] -= numc;
                }
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if (result.containsKey(i)) {
                for (int j = 0; j < result.get(i); j++) {
                    res.append(i);
                }
            }
        }
        return res.toString();
    }
}

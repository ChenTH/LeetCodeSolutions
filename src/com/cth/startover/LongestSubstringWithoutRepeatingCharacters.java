package com.cth.startover;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    private static int getLongestSubstringWithoutRepeatingCharacters(String str) {
        int[] nums = new int[str.length()];
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                j = Math.max(map.get(str.charAt(i)) + 1, j);
            }
            if (i - j + 1 > res) {
                res = i - j + 1;
            }
            map.put(str.charAt(i), i);
        }
        return res;
    }
}

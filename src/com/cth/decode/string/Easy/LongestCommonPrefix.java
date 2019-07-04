package com.cth.decode.string.Easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] aStrings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(aStrings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }
        ;
        if (strs.length == 0) {
            return "";
        }
        ;
        StringBuilder ss = new StringBuilder();
        int index = 0;
        while (true) {
            if (index < strs[0].length()) {
                char a = strs[0].charAt(index);
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() > index) {
                        if (strs[i].charAt(index) != a) {
                            return ss.toString();
                        }
                    } else {
                        return ss.toString();
                    }
                }
                ss.append(a);
                index++;
            } else {
                return ss.toString();
            }

        }
    }
}

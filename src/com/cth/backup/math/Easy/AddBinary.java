package com.cth.backup.math.Easy;

import java.util.ArrayList;

public class AddBinary {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = "100";
        String s2 = "110110";
        String s3 = addBinary(s1, s2);
        System.out.println(s3);
    }

    public static String addBinary(String a, String b) {
        if (a == null && b == null) {
            return a;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        String shortstr = a.length() < b.length() ? a : b;
        String longstr = shortstr.equals(a) ? b : a;
        int carry = 0;
        for (int i = 0; i < longstr.length(); i++) {
            if (i < shortstr.length()) {
                int shortpost = shortstr.charAt(shortstr.length() - i - 1) - 48;
                int longpost = longstr.charAt(longstr.length() - i - 1) - 48;
                int res = shortpost + longpost + carry;
                arr.add(res % 2);
                carry = res / 2;
            } else {
                int longpost = longstr.charAt(longstr.length() - i - 1) - 48;
                int res = longpost + carry;
                arr.add(res % 2);
                carry = res / 2;
            }
        }
        if (carry == 1) {
            arr.add(1);
        }
        String result = "";
        for (int i = 0; i < arr.size(); i++) {
            result += arr.get(arr.size() - i - 1);
        }
        return result;
    }
}

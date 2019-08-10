package com.cth.backup.math.Easy;

public class RomantoInteger {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String rom = "MCMXCVI";
        System.out.println(romanToInt(rom));
    }

    public static int romanToInt(String s) {
        if (s.length() < 1) return 0;
        int result = 0;
        int sub = getRomanValue(s.charAt(0));
        int bef = sub;
        for (int i = 1; i < s.length(); i++) {
            int now = getRomanValue(s.charAt(i));
            if (now == bef) {
                sub += now;
            } else if (now < bef) {
                result += sub;
                sub = now;
            } else {
                sub = now - sub;
            }
            bef = now;
        }
        result += sub;
        return result;
    }

    public static int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

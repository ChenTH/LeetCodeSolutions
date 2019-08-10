package com.cth.backup.TwoPointers.Easy;

public class ValidPalindrome {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "aA";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        ;
        if (s.length() == 0) {
            return true;
        }
        ;
        int bef = 0;
        int last = s.length() - 1;
        while (true) {
            for (int i = bef; i <= last; i++) {
                bef = i;
                if (isalphanumeric(s.charAt(i))) {
                    break;
                }
            }
            for (int i = last; i >= bef; i--) {
                last = i;
                if (isalphanumeric(s.charAt(i))) {
                    break;
                }
            }
            if (bef < last) {
                if (isEqual(s.charAt(bef), s.charAt(last))) {
                    bef = bef + 1;
                    last = last - 1;
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    public static boolean isalphanumeric(char a) {
        if (a >= 65 && a <= 90) {//大写
            return true;
        } else if (a >= 97 && a <= 122) {//小写
            return true;
        } else if (a >= 48 && a <= 57) {//数字
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEqual(char a, char b) {
        if (a == b) {//相等 包括数字相等
            return true;
        } else if (Character.isLetter(a) && Character.isLetter(b)) {//两个都是字母
            int span = Math.abs(a - b);
            if (span == 0 || span == 32) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

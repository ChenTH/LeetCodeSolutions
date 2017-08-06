package com.cth.decode.string.Easy;

/**
 * Created by SherlockTHao on 2017/5/21.
 */
public class ReverseStringII {
    public static void main(String[] args) {
        String a = "a";
        System.out.print(reverseStr(a, 2));
    }

    public static String reverseStr(String s, int k) {
        char[] sc = s.toCharArray();
        int n = s.length() / k, i = 0;
        while (i <= n) {
            if ((i + 1) * k - 1 < s.length()) {
                reverse(sc, i * k, (i + 1) * k - 1);
            } else {
                reverse(sc, i * k, s.length()-1);
            }
            i+=2;
        }
        return new String(sc);
    }

    public static void reverse(char[] sc, int beg, int end) {
        while (beg < end) {
            char a = sc[beg];
            sc[beg] = sc[end];
            sc[end] = a;
            beg++;
            end--;
        }
    }
}

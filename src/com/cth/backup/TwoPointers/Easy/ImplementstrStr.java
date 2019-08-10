package com.cth.backup.TwoPointers.Easy;

public class ImplementstrStr {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }
        int hlen = haystack.length();
        int nlen = needle.length();
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < hlen && j < nlen) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == nlen) {
            return i - nlen;
        } else {
            return -1;
        }
    }

    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int p = 1, k = 0; p < needle.length(); p++) {
            while ((needle.charAt(p) != needle.charAt(k)) && k > 0) {
                k = next[k - 1];
            }
            if (needle.charAt(p) == needle.charAt(k)) {
                k++;
            }
            next[p] = k;
        }
        return next;
    }
}

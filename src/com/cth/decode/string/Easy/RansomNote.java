package com.cth.decode.string.Easy;

public class RansomNote {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String aString = "aa";
        String bString = "aab";
        canConstruct(bString, aString);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        for (char b : magazine.toCharArray()) {
            a[b - 97]++;
        }
        for (char b : ransomNote.toCharArray()) {
            if (--(a[b - 97]) < 0) {
                return false;
            }
        }
        return true;
    }
}

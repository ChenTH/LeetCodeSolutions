package com.cth.decode.DynamicProgramming.Medium;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String aString = "babcbabcbaccba";
        System.out.println(longestPalindrome(aString));
        System.out.println(longestPalindrome2(aString));
    }

    public static String longestPalindrome(String s) {
        // 翻转后求最长公共子串,错误方法
        String t = reverse(s);
        int[] dp = new int[s.length()];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (j != 0) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        dp[j] = 1;
                    }
                } else {
                    dp[j] = 0;
                }
                if (dp[j] > max) {
                    max = dp[j];
                    maxIndex = j;
                }
            }
        }
        return t.substring(maxIndex - max + 1, maxIndex + 1);
    }

    public static String reverse(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse(right) + reverse(left);
    }

    public static String longestPalindrome2(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i) {
                        dp[i][j] = 1;
                    } else if (i - j == 1) {
                        dp[i][j] = 2;
                    } else {
                        if (dp[i - 1][j + 1] != 0) {
                            dp[i][j] = dp[i - 1][j + 1] + 2;
                        } else {
                            dp[i][j] = 0;
                        }
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        maxIndex = j;
                    }
                }
            }
        }
        return s.substring(maxIndex, maxIndex + max);
    }

    private int lo, maxLen;

    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i); // assume odd length, try to extend
            // Palindrome as possible
            extendPalindrome(s, i, i + 1); // assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}

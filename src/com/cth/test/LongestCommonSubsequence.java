package com.cth.test;

import org.w3c.dom.CDATASection;

public class LongestCommonSubsequence {

    public static int[][] dp = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String aString = "ABCBDAB";
        String bString = "BDCABA";
        dp = new int[aString.length()][bString.length()];
        for (int i = 0; i < aString.length(); i++) {
            for (int j = 0; j < bString.length(); j++) {
                dp[i][j] = -2;
            }
        }
        System.out.println(search(0, 0, aString.toCharArray(), bString.toCharArray()));
        System.out.println(search2(0, 0, aString.toCharArray(), bString.toCharArray()));
        System.out.println(dpSolution(aString.toCharArray(), bString.toCharArray()));
    }

    public static int search(int i, int j, char[] cs, char[] cs2) {
        if (i > cs.length || j > cs2.length) {
            return -1;
        }
        if (i == cs.length || j == cs2.length) {
            return 0;
        }
        int n1 = 0, n2 = 0, n3 = 0;
        if (cs[i] == cs2[j]) {
            n1 = search(i + 1, j + 1, cs, cs2) + 1;
        }
        n3 = search(i + 1, j, cs, cs2);
        n2 = search(i, j + 1, cs, cs2);
        return Math.max(n3, Math.max(n1, n2));
    }

    public static int search2(int i, int j, char[] cs, char[] cs2) {
        if (i > cs.length || j > cs2.length) {
            return -1;
        }
        if (i == cs.length || j == cs2.length) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int n1 = 0, n2 = 0, n3 = 0;
        if (cs[i] == cs2[j]) {
            n1 = search(i + 1, j + 1, cs, cs2) + 1;
        }
        n3 = search(i + 1, j, cs, cs2);
        n2 = search(i, j + 1, cs, cs2);
        dp[i][j] = Math.max(n3, Math.max(n1, n2));
        return dp[i][j];
    }

    public static int dpSolution(char[] cs, char[] cs2) {
        if (cs.length == 0 || cs2.length == 0) {
            return 0;
        }
        int[][] dp2 = new int[cs.length][cs2.length];
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs2.length; j++) {
                int n1 = 0, n2 = 0, n3 = 0;

                if (cs[i] == cs2[j]) {
                    if (i > 0 && j > 0) {
                        n1 = dp2[i - 1][j - 1] + 1;
                    } else {
                        n1 = 1;
                    }
                }

                if (i > 0) {
                    n2 = dp2[i - 1][j];
                }
                if (j > 0) {
                    n3 = dp2[i][j - 1];
                }
                dp2[i][j] = Math.max(n1, Math.max(n2, n3));
            }
        }
        return dp2[cs.length - 1][cs2.length - 1];
    }
}

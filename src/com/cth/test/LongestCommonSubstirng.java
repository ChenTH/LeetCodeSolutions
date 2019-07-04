package com.cth.test;

import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubstirng {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str1 = new String("123456abcd567");
        String str2 = new String("234dddabc45678");
        System.out.println(LongestCommonSubstirng1(str1.toCharArray(), str2.toCharArray()));
        System.out.println(LongestCommonSubstirng2(str1.toCharArray(), str2.toCharArray()));
    }

    public static int LongestCommonSubstirng1(char[] cs, char[] cs2) {
        if (cs.length == 0 || cs2.length == 0) {
            return 0;
        }
        int[][] dp2 = new int[cs.length][cs2.length];
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs2.length; j++) {
                if (cs[i] == cs2[j]) {
                    if (i > 0 && j > 0) {
                        dp2[i][j] = dp2[i - 1][j - 1] + 1;
                    } else {
                        dp2[i][j] = 1;
                    }
                } else {
                    dp2[i][j] = 0;
                }
                if (dp2[i][j] > max) {
                    max = dp2[i][j];
                }
            }
        }
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs2.length; j++) {
                if (dp2[i][j] == max) {
                    for (int k = max - 1; k >= 0; k--) {
                        System.out.print(cs[i - k]);
                    }
                    System.out.println();
                }
            }
        }
        return max;
    }

    public static int LongestCommonSubstirng2(char[] cs, char[] cs2) {
        if (cs.length == 0 || cs2.length == 0) {
            return 0;
        }
        int[] dp = new int[cs2.length];
        int max = 0;
        List<Integer> maxindex = new LinkedList<>();
        int maxcount = -1;
        for (int i = 0; i < cs.length; i++) {
            for (int j = cs2.length - 1; j >= 0; j--) {
                if (cs[i] == cs2[j]) {
                    if (j > 0) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        dp[j] = 1;
                    }
                } else {
                    dp[j] = 0;
                }

                if (dp[j] > max) {
                    max = dp[j];
                    maxcount = 0;
                    maxindex.clear();
                    maxindex.add(j);
                } else if (dp[j] == max) {
                    maxcount++;
                    maxindex.add(j);
                }
            }
        }
        for (int j = 0; j <= maxcount; j++) {
            for (int i = max - 1; i >= 0; i--) {
                System.out.print(cs2[maxindex.get(j) - i]);
            }
            System.out.println();
        }
        return max;
    }
}

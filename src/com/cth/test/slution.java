package com.cth.test;

import java.util.ArrayList;
import java.util.Scanner;

public class slution {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        if((line1 != null && !line1.isEmpty()) && (line2 != null && !line2.isEmpty())) {
            boolean res = filter(line1,line2);
            System.out.println(res?1:0);
        }
    }
    public static boolean filter(String s, String p) {
        boolean[][] dp = new boolean[2][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (j == 0) {
                	dp[i % 2][j] = i == 0;
                    continue;
                }
                if (p.charAt(j - 1) != '*') {
                	dp[i % 2][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[(i - 1) % 2][j - 1];
                } else {
                	dp[i % 2][j] = (i > 0 && dp[(i - 1) % 2][j]) || dp[i % 2][j - 1];
                }
                
            }
        }
        return dp[s.length() % 2][p.length()];
    }
}

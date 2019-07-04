package com.cth.startover;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "adfsadfvasdsdafsa";
        String b = "sdfabasdfwerewr";
        System.out.println(getLongestCommonSubsequence(a, b));
    }

    private static int getLongestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int val = 0;
                if (str1.charAt(i) == str2.charAt(j)) {
                    val = 1;
                }
                if (i == 0 || j == 0) {
                    //如果在左边缘或者上边缘部分则直接赋值
                    dp[i][j] = val;
                } else {
                    //如果在中间部位则进行递推
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1] + val));
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[str1.length() - 1][str2.length() - 1];
    }
}

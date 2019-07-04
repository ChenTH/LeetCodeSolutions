package com.cth.startover;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String a = "adfsadfvasdsdafsa";
        String b = "sdfabasdfwerewr";
        System.out.println(getLongestCommonSubstringLengthSimplify(a, b));
    }

    private static String getLongestCommonSubstringLength(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        int res = 0, index = -1;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        //如果在左边缘或者上边缘部分则直接赋值
                        dp[i][j] = 1;
                    } else {
                        //如果在中间部位则进行递推
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > res) {
                        index = i;
                        res = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }

                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        if (res > 0) {
            return str1.substring(index - res + 1, index + 1);
        } else {
            return "";
        }
    }

    private static String getLongestCommonSubstringLengthSimplify(String str1, String str2) {
        int[] dp = new int[str2.length()];
        int res = 0, index = -1;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        //如果在左边缘或者上边缘部分则直接赋值
                        dp[j] = 1;
                    } else {
                        //如果在中间部位则进行递推
                        dp[j] = dp[j - 1] + 1;
                    }
                    if (dp[j] > res) {
                        index = i;
                        res = dp[j];
                    }
                } else {
                    dp[j] = 0;
                }
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        if (res > 0) {
            return str1.substring(index - res + 1, index + 1);
        } else {
            return "";
        }
    }
}

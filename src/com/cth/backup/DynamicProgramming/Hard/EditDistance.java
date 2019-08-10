package com.cth.backup.DynamicProgramming.Hard;

public class EditDistance {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[i][j] = j;
                    } else {
                        dp[i][j] = i;
                    }
                } else {
                    int n1, n2, n3;
                    n1 = dp[i - 1][j] + 1;
                    n2 = dp[i][j - 1] + 1;
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        n3 = dp[i - 1][j - 1];
                    } else {
                        n3 = dp[i - 1][j - 1] + 1;
                    }
                    dp[i][j] = Math.min(n3, Math.min(n1, n2));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

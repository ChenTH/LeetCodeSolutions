package com.cth.startover;

public class LevenshteinDistance {
    public static void main(String[] args) {
        String str1 = "fdsafafefwercewrcwf";
        String str2 = "gdfgadkghjkjfioawejoif";
        System.out.println(getLevenshteinDistance4(str1, str2));
    }

    public static int getLevenshteinDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= str2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static int getLevenshteinDistance2(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            if (str1.length() == 0) {
                return str2.length();
            } else {
                return str1.length();
            }
        }
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int left, top, diagonal;
                if (i == 0 && j == 0) {
                    left = 1;
                    top = 1;
                    diagonal = 0;
                } else if (i == 0 && j != 0) {
                    left = dp[i][j - 1];
                    top = j + 1;
                    diagonal = j;
                } else if (i != 0 && j == 0) {
                    left = i + 1;
                    diagonal = i;
                    top = dp[i - 1][j];
                } else {
                    top = dp[i - 1][j];
                    left = dp[i][j - 1];
                    diagonal = dp[i - 1][j - 1];
                }
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = Math.min(diagonal, Math.min(left + 1, top + 1));
                } else {
                    dp[i][j] = Math.min(diagonal + 1, Math.min(left + 1, top + 1));
                }
            }
        }
        return dp[str1.length() - 1][str2.length() - 1];
    }

    public static int getLevenshteinDistance3(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            if (str1.length() == 0) {
                return str2.length();
            } else {
                return str1.length();
            }
        }
        int[] topArray = new int[str2.length()];
        int[] currentArray = new int[str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int left, top, diagonal;
                if (i == 0 && j == 0) {
                    left = 1;
                    top = 1;
                    diagonal = 0;
                } else if (i == 0 && j != 0) {
                    left = currentArray[j - 1];
                    top = j + 1;
                    diagonal = j;
                } else if (i != 0 && j == 0) {
                    left = i + 1;
                    diagonal = i;
                    top = topArray[j];
                } else {
                    top = topArray[j];
                    left = currentArray[j - 1];
                    diagonal = topArray[j - 1];
                }
                if (str1.charAt(i) == str2.charAt(j)) {
                    currentArray[j] = Math.min(diagonal, Math.min(left + 1, top + 1));
                } else {
                    currentArray[j] = Math.min(diagonal + 1, Math.min(left + 1, top + 1));
                }
                System.out.print(currentArray[j] + " ");
            }
            int[] tempArray = currentArray;
            currentArray = topArray;
            topArray = tempArray;
            System.out.println();
        }
        return topArray[str2.length() - 1];
    }

    public static int getLevenshteinDistance4(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            if (str1.length() == 0) {
                return str2.length();
            } else {
                return str1.length();
            }
        }
        int[] disArray = new int[str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            int diagonal = i;
            for (int j = 0; j < str2.length(); j++) {
                int left, top;
                if (i == 0 && j == 0) {
                    left = 1;
                    top = 1;
                    diagonal = 0;
                } else if (i == 0 && j != 0) {
                    left = disArray[j - 1];
                    top = j + 1;
                    diagonal = j;
                } else if (i != 0 && j == 0) {
                    left = i + 1;
                    top = disArray[j];
                    diagonal = i;
                } else {
                    top = disArray[j];
                    left = disArray[j - 1];
                }
                int tmp = disArray[j];
                if (str1.charAt(i) == str2.charAt(j)) {
                    disArray[j] = Math.min(diagonal, Math.min(left + 1, top + 1));
                } else {
                    disArray[j] = Math.min(diagonal + 1, Math.min(left + 1, top + 1));
                }
                diagonal = tmp;
                System.out.print(disArray[j] + " ");
            }
            System.out.println();
        }
        return disArray[str2.length() - 1];
    }
}

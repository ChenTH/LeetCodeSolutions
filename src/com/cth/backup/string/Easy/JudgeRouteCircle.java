package com.cth.backup.string.Easy;

public class JudgeRouteCircle {
    public static void main(String[] args) {
        String s = "DURDLDRRLL";
        System.out.print(judgeCircle(s));
    }

    public static boolean judgeCircle(String moves) {
        char[] eachMoves = moves.toCharArray();
        int left = 0;
        int up = 0;
        for (char c : eachMoves) {
            if (c == 'R') {
                left--;
            } else if (c == 'L') {
                left++;
            } else if (c == 'U') {
                up++;
            } else if (c == 'D') {
                up--;
            }
        }
        if (left == 0 && up == 0) {
            return true;
        } else {
            return false;
        }
    }
}

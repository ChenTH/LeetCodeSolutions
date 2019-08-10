package com.cth.backup.math.Easy;

public class ArrangingCoins {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(arrangeCoins(1));
    }

    public static int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        double result = (Math.sqrt(1 + 8.0 * n) - 1) / 2;
        return (int) result;
    }
}

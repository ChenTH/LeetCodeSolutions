package com.cth.decode.math.Easy;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 100;
        System.out.println(trailingZeroes(a));
    }

    public static int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}

package com.cth.backup.math.Easy;

public class ReverseInteger {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 563847412;
        System.out.println(reverse(a));
    }

    public static int reverse(int x) {
        int origin = x;
        int reverse = 0;
        int post = 0;
        while (origin != 0) {
            if (reverse > 0 && post == 9) {
                if (2147483647 / 10 < reverse || (2147483647 / 10 == reverse && origin % 10 > 7)) {
                    return 0;
                }
            } else if (reverse < 0 && post == 9) {
                if (-2147483647 / 10 > reverse || (-2147483647 / 10 == reverse && origin % 10 < -8)) {
                    return 0;
                }
            }
            reverse = reverse * 10 + origin % 10;
            origin = origin / 10;
            post++;
        }
        return reverse;
    }
}

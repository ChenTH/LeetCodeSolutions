package com.cth.backup.math.Easy;

public class UglyNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }
}

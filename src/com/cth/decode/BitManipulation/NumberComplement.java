package com.cth.decode.BitManipulation;

public class NumberComplement {
    public int findComplement(int num) {
        int result = 0;
        int count = 0;
        for (; num > 0; num /= 2) {
            if (num % 2 == 0) {
                result += Math.pow(2, count);
            }
            count++;
        }
        return result;
    }
}

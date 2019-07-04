package com.cth.decode.BitManipulation;

public class PowerofFour {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 15;
        System.out.println(isPowerOfFour(a));
    }

    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }

}

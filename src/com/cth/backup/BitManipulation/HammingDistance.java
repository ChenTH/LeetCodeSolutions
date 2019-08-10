package com.cth.backup.BitManipulation;

public class HammingDistance {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int result = 0;
        while (x != 0 || y != 0) {
            if (x % 2 == y % 2) {
                result++;
            }
            x /= 2;
            y /= 2;
        }
        return result;
    }

}

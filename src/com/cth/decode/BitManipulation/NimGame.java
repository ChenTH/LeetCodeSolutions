package com.cth.decode.BitManipulation;

public class NimGame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean canWinNim(int n) {
        return (n & 0x3) != 0;
    }
}

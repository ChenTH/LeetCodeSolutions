package com.cth.decode.BitManipulation;

public class ReverseBits {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int v) {
// 交换每两位
        v = ((v >> 1) & 0x55555555) | ((v & 0x55555555) << 1);
// 交换每四位中的前两位和后两位
        v = ((v >> 2) & 0x33333333) | ((v & 0x33333333) << 2);
// 交换每八位中的前四位和后四位
        v = ((v >> 4) & 0x0F0F0F0F) | ((v & 0x0F0F0F0F) << 4);
// 交换相邻的两个字节
        v = ((v >> 8) & 0x00FF00FF) | ((v & 0x00FF00FF) << 8);
// 交换前后两个双字节
        v = (v >> 16) | (v << 16);
        return v;
    }
}

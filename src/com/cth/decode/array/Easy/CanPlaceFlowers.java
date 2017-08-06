package com.cth.decode.array.Easy;

/**
 * Created by SherlockTHao on 2017/8/3.
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int beg = -1, end = -1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i==0) {
                    beg = -1;
                } else if (flowerbed[i - 1] == 1) {
                    beg = i;
                }

                if (i + 1 == flowerbed.length) {
                    end = i + 1;
                    int tem=end-beg+1;
                    if(tem%2==1){
                        n-=tem/2;
                    }
                    else {
                        n-=tem/2-1;
                    }
                    if(n<=0){
                        break;
                    }
                } else if (flowerbed[i + 1] == 1) {
                    end = i;
                    int tem=end-beg+1;
                    if(tem%2==1){
                        n-=tem/2;
                    }
                    else {
                        n-=tem/2-1;
                    }
                    if(n<=0){
                        break;
                    }
                }
            }
        }
        if (n <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] flowerbed = {0, 0,1, 0, 1};
        System.out.print(canPlaceFlowers(flowerbed, 1));
    }
}

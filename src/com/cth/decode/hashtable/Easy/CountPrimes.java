package com.cth.decode.hashtable.Easy;

public class CountPrimes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(countPrimes2(1500000));
    }

    public static int countPrimes(int n) {
        int count = 0;
        boolean flag = true;
        if (n >= 2) {
            count++;
        }
        for (int i = 3; i < n; i = i + 2) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + "   ");
                count++;
            }
            flag = true;
        }
        return count;
    }

    public static int countPrimes2(int n) {
        boolean[] a = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!a[i]) {
                for (int j = i; j * i < n; j++) {
                    a[i * j] = true;
                }
            }
        }
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (!a[i]) {
                c++;
            }
        }
        return c;
    }
}

package com.cth.backup.math.Medium;

public class BulbSwitcher {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        bulbSwitch(9999999);
    }

    public static int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        for (int i = 0; i < n; i++) {
            bulbs[i] = false;
        }
        for (int i = 1; i <= n; i++) {
            toggleNThBulb(bulbs, i);
        }
        int result = 0;
        for (int i = 0; i < bulbs.length; i++) {
            if (bulbs[i]) {
                result++;
            }
        }
        return result;
    }

    public static void toggleNThBulb(boolean[] bulbs, int n) {
        int i = -1;
        while ((i + n) < bulbs.length) {
            bulbs[i + n] = bulbs[i + n] ? false : true;
            i = i + n;
        }
    }

    public static int bulbSwitch2(int n) {
        return (int) Math.sqrt(n);
    }
}

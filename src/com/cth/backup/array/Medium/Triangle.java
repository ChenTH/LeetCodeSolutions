package com.cth.backup.array.Medium;

import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int deep = triangle.size();
        int[] a = new int[deep];
        a[0] = triangle.get(0).get(0);
        for (int i = 1; i < deep; i++) {
            List<Integer> list = triangle.get(i);
            int size = list.size();
            a[size - 1] = a[size - 2] + list.get(size - 1);
            for (int j = size - 2; j > 0; j--) {
                int left = list.get(j) + a[j - 1];
                int right = list.get(j) + a[j];
                a[j] = left < right ? left : right;
            }
            a[0] = a[0] + list.get(0);
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
}

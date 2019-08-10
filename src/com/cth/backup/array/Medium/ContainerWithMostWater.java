package com.cth.backup.array.Medium;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 1};
        System.out.println(maxArea2(a));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int a = Math.min(height[i], height[j]) * (j - i);
                if (a > max) {
                    max = a;
                }
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i <= j) {
            int a = Math.min(height[i], height[j]) * (j - i);
            if (a > max) {
                max = a;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}

package com.cth.backup.DynamicProgramming.Easy;

public class ClimbingStairs {
    public int num = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(climbStairs2(38));
    }

    public static int climbStairs(int n) {
        return DFS(0, n);
    }

    public static int DFS(int n, int target) {
        if (n > target) {
            return 0;
        } else if (n == target) {
            return 1;
        } else {
            return DFS(n + 1, target) + DFS(n + 2, target);
        }
    }

    public static int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        }
        ;
        if (n == 1) {
            return 1;
        }
        ;
        if (n == 2) {
            return 2;
        }
        ;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}

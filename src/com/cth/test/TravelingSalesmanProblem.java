package com.cth.test;

import java.util.Map;

public class TravelingSalesmanProblem {
    int[][] map = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public Integer search(int idx, int n, int count, boolean[] visit) {
        if (count == n) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                int t = search(i, n, count + 1, visit) + map[idx][i];
                if (t < min) {
                    min = t;
                }
                visit[i] = false;
            }
        }
        return min;
    }
}

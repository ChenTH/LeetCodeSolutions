package com.cth.interview.oj.cow0519;

/**
 * Created by SherlockTHao on 2017/5/19.
 */

import java.util.Arrays;
import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] avg = new int[3 * n];
        for (int i = 0; i < n * 3; i++) {
            avg[i] = in.nextInt();
        }
        Arrays.sort(avg);
        int res = 0;
        for (int i = n; i < n * 3; i = i + 2) {
            res += avg[i];
        }
        System.out.print(res);
    }
}

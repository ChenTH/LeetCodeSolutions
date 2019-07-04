package com.cth.interview.oj.cow0519;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SherlockTHao on 2017/5/19.
 */
public class question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            System.out.print(0);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        int flag = 0;
        int res = 1;
        int bef = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < bef) {
                if (flag == 0) {
                    flag = 1;
                } else if (flag == 2) {
                    res++;
                    flag = 0;
                }
            } else if (list.get(i) > bef) {
                if (flag == 0) {
                    flag = 2;
                } else if (flag == 1) {
                    flag = 0;
                    res++;
                }
            }
            bef = list.get(i);

        }
        System.out.print(res);
    }
}

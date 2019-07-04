package com.cth.interview.oj.cow0725;

import java.util.Scanner;

/**
 * Created by SherlockTHao on 2017/7/25.
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] count = new int[26];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        int oddCount = 0, evenCount = 0;
        for (int c : count) {
            if (c % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        if (oddCount == 0) {
            System.out.print(evenCount);
        }
        System.out.print(oddCount);
    }
}

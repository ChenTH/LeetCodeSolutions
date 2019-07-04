package com.cth.test;

import java.util.Scanner;

/**
 * Created by SherlockTHao on 2017/3/21.
 */
public class fixpalindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String a = in.next();
            char[] b = a.toCharArray();
            int bef = 0;
            int end = b.length - 1;
            if (b.length <= 1) {
                System.out.println("NO");
                return;
            }
            int sumleft = 1;
            int sumright = 1;
            while (bef <= end) {
                if (sumleft == 0 && sumright != 0) {
                    if (bef != end) {
                        sumright *= b[end] - '0';
                        end--;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else if (sumleft != 0 && sumright == 0) {
                    if (bef != end) {
                        sumleft *= b[bef] - '0';
                        bef++;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    if (sumleft == sumright) {
                        if (bef != end) {
                            sumright *= b[end] - '0';
                            end--;
                            sumleft *= b[bef] - '0';
                            bef++;
                        } else {
                            System.out.println("NO");
                            return;
                        }

                    } else if (sumleft > sumright) {
                        sumright *= b[end] - '0';
                        end--;
                    } else {
                        sumleft *= b[bef] - '0';
                        bef++;
                    }
                }
            }
            if (sumleft == sumright) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}

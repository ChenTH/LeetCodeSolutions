package com.cth.test;

/**
 * Created by SherlockTHao on 2017/7/13.
 */
public class intern {
    public static void main(String[] args) {
        String a = "b";
        String b = "b";

        System.out.println(a == b);

        String c = "d";
        String d = new String("d").intern();
        System.out.println(c == d);

        String s1 = "ab123";
        String s2 = new String("ab123");
        System.out.println(s1 == s2);
        String s3 = s2.intern();
        System.out.println(s1 == s3);
    }
}

package com.cth.test;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Baidu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread t = new Thread() {
            public void run() {
                baidu();
            }
        };
        t.run();
        System.out.println("hello");
    }

    static synchronized void baidu() {
        System.out.println("baidu");
    }
}

package com.cth.test.Thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by SherlockTHao on 2017/5/26.
 */
public class AtomicReferenceTest {
    public final static AtomicReference<String> atomicString = new AtomicReference<String>("hosee");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int num = i;
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int) Math.random() * 100));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (atomicString.compareAndSet("hosee", "ztk")) {
                        System.out.println(Thread.currentThread().getId() + "Change value");
                    } else {
                        System.out.println(Thread.currentThread().getId() + "Failed");
                    }
                }

                ;
            }.start();
        }
    }

}

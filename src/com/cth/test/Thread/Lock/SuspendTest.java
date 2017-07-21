package com.cth.test.Thread.Lock;

/**
 * Created by SherlockTHao on 2017/5/26.
 */
public class SuspendTest {
    static Object u = new Object();
    static TestSuspendThread t1 = new TestSuspendThread("t1");
    static TestSuspendThread t2 = new TestSuspendThread("t2");

    public static class TestSuspendThread extends Thread {
        public TestSuspendThread(String name) {
            setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
                System.out.println("out "+getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }
}
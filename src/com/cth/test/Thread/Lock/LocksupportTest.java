package com.cth.test.Thread.Lock;

/**
 * Created by SherlockTHao on 2017/5/26.
 */

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LocksupportTest {
    static Object u = new Object();
    static ReentrantLock lock = new ReentrantLock();
    static TestSuspendThread t1 = new TestSuspendThread("t1");
    static TestSuspendThread t2 = new TestSuspendThread("t2");

    public static class TestSuspendThread extends Thread {
        public TestSuspendThread(String name) {
            setName(name);
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println("in " + getName());
            //Thread.currentThread().suspend();
            LockSupport.park();
            System.out.println("out " + getName());
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}

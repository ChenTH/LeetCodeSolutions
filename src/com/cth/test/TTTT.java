package com.cth.test;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TTTT {
    public static void main(String[] args) {

        Thread i1 = new Thread(new RunIt3());
        Thread i2 = new Thread(new RunIt3());
        i1.start();
        i2.start();
        i2.interrupt();
    }

}

class RunIt3 implements Runnable {

    private static Lock lock = new ReentrantLock();

    public void run() {
        try {
            //---------------------------------a  
//            lock.lock();  
            lock.lockInterruptibly();


            System.out.println(Thread.currentThread().getName() + " running");
            TimeUnit.SECONDS.sleep(20);
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");

        }

    }
}  

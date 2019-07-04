package com.cth.test.Thread.Lock;

/**
 * Created by SherlockTHao on 2017/5/26.
 */
public class VisibilityTest extends Thread {
    volatile private boolean stop = false;

    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.print("Thread Stoped");
    }

    public boolean getStop() {
        return stop;
    }

    public void stopIt() {
        stop = true;
    }

    public static void main(String[] args) throws Exception {
        VisibilityTest test = new VisibilityTest();
        test.start();
        Thread.sleep(1000);
        test.stopIt();
        Thread.sleep(2000);
        System.out.print("finish main");
        System.out.print(test.getStop());
    }

}

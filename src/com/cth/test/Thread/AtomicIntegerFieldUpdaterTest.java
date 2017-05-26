package com.cth.test.Thread;

/**
 * Created by SherlockTHao on 2017/5/26.
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


public class AtomicIntegerFieldUpdaterTest {
    public static class V {
        int id;
        volatile int score;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }

    public final static AtomicIntegerFieldUpdater<V> vv = AtomicIntegerFieldUpdater.newUpdater(V.class, "score");

    public static AtomicInteger allscore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final V stu = new V();
        Thread[] t = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            t[i] = new Thread() {
                @Override
                public void run() {
                    if (Math.random() > 0.4) {
                        vv.incrementAndGet(stu);
                        allscore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }
        for (int i = 0; i < 10000; i++) {
            t[i].join();
        }
        System.out.println("score=" + stu.getScore());
        System.out.println("allscore=" + allscore);
    }
}
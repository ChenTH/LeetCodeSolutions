package com.cth.test.Thread.Executor;

/**
 * Created by SherlockTHao on 2017/5/26.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread ID:"
                    + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            es.submit(myTask);
        }
        secheduleExecutorServiceTest();
    }

    public static void secheduleExecutorServiceTest() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        //如果前面的任务还未完成，则调度不会启动。
        ses.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }, 0, 2, TimeUnit.SECONDS);//启动0秒后执行，然后周期2秒执行一次
    }
}
package com.cth.test;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class justTest {
	public static void main(String args[]) {
		new Thread() {
			public void run() {
				System.out.println("123321");
				try {
					Thread.sleep(1000);
					System.out.println("22222");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Runnable1");
				try {
					Thread.sleep(1000);
					System.out.println("Runnable2");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		ExecutorService pool = Executors.newFixedThreadPool(3);
				for(int i=0;i<10;i++)
				{
				 pool.execute(new Runnable(){public void run(){}});
				}
				Executors.newCachedThreadPool().execute(new Runnable(){public void run(){}});
				Executors.newSingleThreadExecutor().execute(new Runnable(){public void run(){}});

	}

}

package com.cth.test;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread2 = new Thread("t1")
		{
			@Override
			public void run(){
			    while(true){
			        if(Thread.currentThread().isInterrupted()){
			            System.out.println("Interruted!");
			            break;
			        }
			        try {
			           Thread.sleep(2000);
			        } catch (InterruptedException e) {
			           System.out.println("Interruted When Sleep");
			           //设置中断状态，抛出异常后会清除中断标记位
			           Thread.currentThread().interrupt();
			        }
			        Thread.yield();
			    }
			}
		};
		thread2.start();
		thread2.interrupt();
	}

}

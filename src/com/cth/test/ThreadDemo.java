package com.cth.test;

class MyThread2 extends Thread {

	private int ticket = 10;
	private String name;

	public MyThread2(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 500; i++) {
			if (this.ticket > 0) {
				System.out.println(this.name + "鍗栫エ---->" + (this.ticket--));
			}
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		MyThread2 mt1 = new MyThread2("涓�鍙风獥鍙�");
		MyThread2 mt2 = new MyThread2("浜屽彿绐楀彛");
		MyThread2 mt3 = new MyThread2("涓夊彿绐楀彛");
		mt1.start();
		mt2.start();
		mt3.start();
	}

}

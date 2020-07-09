package com.edmund.duntis.warmup.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Main {

	/**
	 * 线程A创建a、b，等待a、b运行完成继续运行
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(() -> {
			// CountDownLatch用于同步
			CountDownLatch c = new CountDownLatch(2);

			new Thread(() -> {
				// Do something here
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":aaa");
				c.countDown();
			}, "a").start(); // 给线程命名

			new Thread(() -> {
				// Do something here
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":bbb");
				c.countDown();
			}, "b").start(); // 给线程命名

			try {
				c.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Do something here
			System.out.println(Thread.currentThread().getName() + ":ccc");
		}, "A").start(); // 给线程命名

	}
}

package com.edmund.duntis.warmup.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main2 {

	public static void main(String[] args) {
		int maxSize = 5; // 最大长度

		Queue<String> queue = new LinkedList<>();

		Random rand = new Random(System.currentTimeMillis());

		Thread producer = new Thread(() -> {
			while (true) { // 生产者一直生产
				// 加入一些随机量
				int i = rand.nextInt(800);
				try {
					Thread.sleep(i);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					synchronized (queue) {
						System.out.println("size:" + queue.size());

						while (queue.size() == maxSize) { // 如果满了，等待未满的信号
							System.out.println("full:" + queue.size());
							queue.wait();
						}

						// 未满的情况下进行生产
						queue.offer(String.valueOf(i));
						System.out.println("offer:" + i);
						queue.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread(() -> { // 消费者一直消费
			while (true) {
				// 加入一些随机量
				int i = rand.nextInt(1000);
				try {
					Thread.sleep(i);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					synchronized (queue) {
						while (queue.isEmpty()) { // 如果空了，等待变成非空的信号
							System.out.println("empty:" + queue.size());
							queue.wait();
						}

						// 如果非空的情况下进行消费
						String e = queue.poll();
						System.out.println("poll:" + e);
						queue.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producer.start();
		consumer.start();
	}

}

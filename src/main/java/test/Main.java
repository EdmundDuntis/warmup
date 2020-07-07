package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		int maxSize = 5; // 最大长度

		Queue<String> queue = new LinkedList<>();
		Lock lock = new ReentrantLock();
		Condition notFull = lock.newCondition();
		Condition notEmpty = lock.newCondition();

		Random rand = new Random(System.currentTimeMillis());

		Thread producer = new Thread(() -> {
			while (true) {
				// 加入一些随机量
				int i = rand.nextInt(800);
				try {
					Thread.sleep(i);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					lock.lock();
					System.out.println("size:" + queue.size());
					if (queue.size() < maxSize) {
						queue.offer(String.valueOf(i));
						System.out.println("offer:" + i);
						notEmpty.signalAll();
					} else {
						System.out.println("full:" + queue.size());
						notFull.await();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});

		Thread consumer = new Thread(() -> {
			while (true) {
				// 加入一些随机量
				int i = rand.nextInt(1000);
				try {
					Thread.sleep(i);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					lock.lock();
					if (!queue.isEmpty()) {
						String e = queue.poll();
						System.out.println("poll:" + e);
						notFull.signalAll();
					} else {
						System.out.println("empty:" + queue.size());
						notEmpty.await();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		producer.start();
		consumer.start();
	}

}

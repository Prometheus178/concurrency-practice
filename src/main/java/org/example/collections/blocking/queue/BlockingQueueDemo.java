package org.example.collections.blocking.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(100);
		WriteQueueWorker writeQueueWorker = new WriteQueueWorker(blockingQueue);
		ReadQueueWorker readQueueWorker = new ReadQueueWorker(blockingQueue);

		Thread thread1 = new Thread(writeQueueWorker);
		Thread thread2 = new Thread(readQueueWorker);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
}

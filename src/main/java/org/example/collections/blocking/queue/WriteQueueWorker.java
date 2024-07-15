package org.example.collections.blocking.queue;

import java.util.concurrent.BlockingQueue;

public class WriteQueueWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;

	public WriteQueueWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {
				System.out.println("PUT: " + counter);
				blockingQueue.put(counter++);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

package org.example.collections.blocking.priority.queue;

import java.util.concurrent.BlockingQueue;

public class ReadFromPriorityQueueWorker implements Runnable {


	private BlockingQueue<Integer> blockingQueue;

	public ReadFromPriorityQueueWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		while (!blockingQueue.isEmpty()) {
			try {
				System.out.println("TAKE: " + blockingQueue.take());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

package org.example.collections.blocking.queue;

import java.util.concurrent.BlockingQueue;

public class ReadQueueWorker implements Runnable {


	private BlockingQueue<Integer> blockingQueue;

	public ReadQueueWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}


	@Override
	public void run() {
		while (true) {
			try {
				Integer takenCounter = blockingQueue.take();
				System.out.println("TAKE: " + takenCounter);
				Thread.sleep(150);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

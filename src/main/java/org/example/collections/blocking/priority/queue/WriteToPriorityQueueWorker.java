package org.example.collections.blocking.priority.queue;

import java.util.concurrent.BlockingQueue;

public class WriteToPriorityQueueWorker implements Runnable {

	private BlockingQueue<Integer> priorityBlockingQueue;

	public WriteToPriorityQueueWorker(BlockingQueue<Integer> priorityBlockingQueue) {
		this.priorityBlockingQueue = priorityBlockingQueue;
	}

	@Override
	public void run() {
			try {
				priorityBlockingQueue.put(4);
				priorityBlockingQueue.put(2);
				priorityBlockingQueue.put(3);
				priorityBlockingQueue.put(1);
				priorityBlockingQueue.put(Integer.MAX_VALUE);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

	}
}

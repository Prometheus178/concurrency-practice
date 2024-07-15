package org.example.collections.blocking.priority.queue;

import org.example.collections.blocking.queue.ReadQueueWorker;
import org.example.collections.blocking.queue.WriteQueueWorker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(10);
		WriteToPriorityQueueWorker writeQueueWorker = new WriteToPriorityQueueWorker(priorityBlockingQueue);
		ReadFromPriorityQueueWorker readQueueWorker = new ReadFromPriorityQueueWorker(priorityBlockingQueue);

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

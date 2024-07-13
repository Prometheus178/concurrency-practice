package org.example.base.join;

import org.example.base.start.CounterWorkerThread;

public class CounterWorkerJoinThreadDemo {

	public static void main(String[] args) {
		System.out.println("Process is started.");

		CounterWorkerThread worker1 = new CounterWorkerThread("A", 10);
		CounterWorkerThread worker2 = new CounterWorkerThread("B", 100);
		worker1.start();
		worker2.start();

		try {
			worker1.join();
			//worker2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Process is finished.");
	}
}

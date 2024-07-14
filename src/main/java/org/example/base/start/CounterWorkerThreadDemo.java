package org.example.base.start;

/**
 *  Representation how to start thread in process
 *  CounterWorkerThread extended class Thread and implemented method run
 */
public class CounterWorkerThreadDemo {

	public static void main(String[] args) {
		System.out.println("Process is started.");

		CounterWorkerThread worker1 = new CounterWorkerThread("A", 100);
		CounterWorkerThread worker2 = new CounterWorkerThread("B", 100);
		worker1.start();
		worker2.start();

		System.out.println("Process is finished.");
	}
}

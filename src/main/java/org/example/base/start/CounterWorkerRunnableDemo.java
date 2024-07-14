package org.example.base.start;

/**
 *  Representation how to start thread in process
 *  CounterWorkerRunnable implemented Runnable interface and override method run
 */
public class CounterWorkerRunnableDemo {

	public static void main(String[] args) {
		System.out.println("Process is started.");

		CounterWorkerRunnable worker1 = new CounterWorkerRunnable("A", 10);
		CounterWorkerRunnable worker2 = new CounterWorkerRunnable("B", 10);
		Thread thread1 = new Thread(worker1);
		Thread thread2 = new Thread(worker2);
		thread1.start();
		thread2.start();

		System.out.println("Process is finished.");

	}
}

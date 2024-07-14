package org.example.synchronization.synchronizzed;

/**
 * Safe increment because each thread have synchronized access to counter by KEY word synchronized
 * on method block code with definition class. Where the thread wait until another thread let it go.
 * Which data stored in HEAP (Heap = RAM)
 */
public class IncrementTwoCounterSynchronizedBlockDemo {

	private static final int COUNT_VALUE = 1_000_000;
	private static Integer counter = 0;
	private static Integer anotheCounter = 0;

	public static void main(String[] args) {
		System.out.println("Process is started.");
		long startTime = System.currentTimeMillis();
		Thread worker1 = new Thread(() -> {
			for (int i = 0; i < COUNT_VALUE; i++) {
				increment();
			}
		});
		Thread worker2 = new Thread(() -> {
			for (int i = 0; i < COUNT_VALUE; i++) {
				incrementAnotherCounter();
			}
		});

		worker1.start();
		worker2.start();

		try {
			worker1.join();
			worker2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (endTime - startTime));
		System.out.println("Counter value: " + counter);
		System.out.println("Another counter value: " + anotheCounter);

		System.out.println("Process is finished.");
	}

	private static void incrementAnotherCounter() {
		synchronized (IncrementTwoCounterSynchronizedBlockDemo.class) {
			anotheCounter++;
		}
	}

	private static void increment() {
		synchronized (IncrementTwoCounterSynchronizedBlockDemo.class) {
			counter++;
		}
	}
}

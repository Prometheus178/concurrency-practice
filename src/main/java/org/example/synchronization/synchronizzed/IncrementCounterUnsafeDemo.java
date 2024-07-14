package org.example.synchronization.synchronizzed;

/**
 * Unsafe increment because each thread have non-synchronized access to counter.
 * Which data stored in HEAP (Heap = RAM)
 */
public class IncrementCounterUnsafeDemo {

	private static final int COUNT_VALUE = 1000;
	private static Integer counter = 0;

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
				increment();
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

		System.out.println("Process is finished.");
	}

	private static void increment() {
		counter++;
	}
}

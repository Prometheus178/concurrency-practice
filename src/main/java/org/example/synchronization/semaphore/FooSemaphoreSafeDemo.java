package org.example.synchronization.semaphore;

/**
 * Representation how started thread in order executed in the same order by semaphore
 */
public class FooSemaphoreSafeDemo {
	public static void main(String[] args) {
		FooSemaphoreSafe fooSafe = new FooSemaphoreSafe();
		Thread thread1 = new Thread(fooSafe::firstPrint);
		Thread thread2 = new Thread(fooSafe::secondPrint);
		Thread thread3 = new Thread(fooSafe::thirdPrint);

		thread1.setName("thread#1");
		thread2.setName("thread#2");
		thread3.setName("thread#3");

		thread1.start();
		thread2.start();
		thread3.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


	}
}

package org.example.synchronization.order;

/**
 *  Representation how started thread in order do not executed in the same order
 */
public class FooUnsafeDemo {
	public static void main(String[] args) {
		FooUnsafe fooUnsafe = new FooUnsafe();
		Thread thread1 = new Thread(fooUnsafe::firstPrint);
		Thread thread2 = new Thread(fooUnsafe::secondPrint);
		Thread thread3 = new Thread(fooUnsafe::thirdPrint);

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

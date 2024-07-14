package org.example.synchronization.order.condition;


/**
 * Representation how started thread in order executed in the same order by condition
 * (but here can be problem with deadlock)
 */
public class FooSafeDemo {
	public static void main(String[] args) {
		FooSafe fooSafe = new FooSafe();
		Thread thread1 = new Thread(fooSafe::firstPrint);
		Thread thread2 = new Thread(fooSafe::secondPrint);
		Thread thread3 = new Thread(fooSafe::thirdPrint);

		thread1.setName("thread1");
		thread2.setName("thread2");
		thread3.setName("thread3");

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

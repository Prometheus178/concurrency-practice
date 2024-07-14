package org.example.synchronization.order.semaphore;

import java.util.concurrent.Semaphore;

public class FooSemaphoreSafe {

	private final Semaphore betweenFirstAndSecond = new Semaphore(0);
	private final Semaphore betweenSecondAndThird = new Semaphore(0);

	public void firstPrint() {
		System.out.println("first");
		betweenFirstAndSecond.release();
	}

	public void secondPrint() {
		try {
			betweenFirstAndSecond.acquire();
			System.out.println("second");
			betweenSecondAndThird.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	public void thirdPrint() {
		try {
			betweenSecondAndThird.acquire();
			System.out.println("third");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

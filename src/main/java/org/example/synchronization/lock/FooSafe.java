package org.example.synchronization.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooSafe {

	private final Lock lock = new ReentrantLock();
	private final Condition firstMethodCalled = lock.newCondition();
	private final Condition secondMethodCalled = lock.newCondition();

	public void firstPrint() {
		lock.lock();
		try {
			System.out.println("first");
			firstMethodCalled.signal();
		} finally {
			lock.unlock();
		}
	}

	public void secondPrint() {
		lock.lock();
		try {
			firstMethodCalled.await();
			System.out.println("second");
			secondMethodCalled.signal();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
	}

	public void thirdPrint() {
		lock.lock();
		try {
			secondMethodCalled.await();
			System.out.println("third");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
	}
}

package org.example.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent problem how average collection work with threads.
 * Each thread re-write value in collection
 */
public class CollectionUnsafeDemo {

	public static void main(String[] args) {
		List<Integer> unsafeList = new ArrayList<>();

		Thread thread1 = new Thread(
				() -> {
					for (int i = 0; i < 1_000_000; i++) {
						unsafeList.add(i);
					}
				}
		);

		Thread thread2 = new Thread(
				() -> {
					for (int i = 0; i < 1_000_000; i++) {
						unsafeList.add(i);
					}
				}
		);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Count elements in list= " + unsafeList.size());
	}
}

package org.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represent how can be solved problem re-write value in collection
 * by using synchronized wrapper in Collections class.
 *
 */
public class CollectionSafeDemo {

	public static void main(String[] args) {
		List<Integer> safeList = Collections.synchronizedList(new ArrayList<>());

		Thread thread1 = new Thread(
				() -> {
					for (int i = 0; i < 1_000_000; i++) {
						safeList.add(i);
					}
				}
		);

		Thread thread2 = new Thread(
				() -> {
					for (int i = 0; i < 1_000_000; i++) {
						safeList.add(i);
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

		System.out.println("Count elements in list= " + safeList.size());
	}
}

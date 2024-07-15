package org.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolDemo {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {// 10398 ms
			for (int i = 0; i < 100; i++) {
				executorService.submit(new GenerateRandomIntegerTask());
			}
		} finally {
			long end = System.currentTimeMillis();
			System.out.println("Evaluated time: " + (end - start));
		}
	}
}

package org.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {

	public static void main(String[] args) {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Count of cores: " + cores);
		long start = System.currentTimeMillis();
		try (ExecutorService executorService = Executors.newCachedThreadPool()) {
			//for (int i = 0; i < 100; i++) { // 100 workers
			//for (int i = 0; i < 10_000; i++) { // 2413 workers
			for (int i = 0; i < 100_000; i++) { // 2753 workers
				executorService.submit(new GenerateRandomIntegerTask());
			}
			System.out.println("BREAK");
		} finally {
			long end = System.currentTimeMillis();
			System.out.println("Evaluated time: " + (end - start));
		}
	}
}

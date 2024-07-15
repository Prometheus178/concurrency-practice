package org.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
	public static void main(String[] args) {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Count of cores: " + cores);
		long start = System.currentTimeMillis();
		//try (ExecutorService executorService = Executors.newFixedThreadPool(100)) { // 100 ms
		try (ExecutorService executorService = Executors.newFixedThreadPool(cores - 1)) { // 1500 ms
			for (int i = 0; i < 100; i++) {
				executorService.submit(new GenerateRandomIntegerTask());
			}
		} finally {
			long end = System.currentTimeMillis();
			System.out.println("Evaluated time: " + (end - start));
		}
	}
}

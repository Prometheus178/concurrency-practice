package org.example.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolCallableDemo {
	public static void main(String[] args) {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Count of cores: " + cores);
		List<Future<Integer>> futures = new ArrayList<>();

		long start = System.currentTimeMillis();
		try (ExecutorService executorService = Executors.newFixedThreadPool(cores * 100)) {
			for (int i = 0; i < 10_000; i++) {
				futures.add(executorService.submit(new GenerateRandomIntegerCallableTask()));
			}
		}

		futures.forEach(integerFuture -> {
			try {
				System.out.println(integerFuture.get());
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		});

		long end = System.currentTimeMillis();
		System.out.println("Evaluated time: " + (end - start));

	}
}

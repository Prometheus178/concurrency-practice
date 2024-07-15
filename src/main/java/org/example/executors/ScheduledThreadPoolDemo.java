package org.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
	public static void main(String[] args) {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		long start = System.currentTimeMillis();
		try (ScheduledExecutorService executorService = Executors.newScheduledThreadPool(availableProcessors - 1)) {
				GenerateRandomIntegerWithIdTask task1 = new GenerateRandomIntegerWithIdTask(1);
				GenerateRandomIntegerWithIdTask task2 = new GenerateRandomIntegerWithIdTask(2);
				GenerateRandomIntegerWithIdTask task3 = new GenerateRandomIntegerWithIdTask(3);
				GenerateRandomIntegerWithIdTask task4 = new GenerateRandomIntegerWithIdTask(4);
				GenerateRandomIntegerWithIdTask task5 = new GenerateRandomIntegerWithIdTask(5);


				executorService.schedule(task1, 10, TimeUnit.SECONDS);
				executorService.schedule(task2, 3, TimeUnit.SECONDS);
				executorService.schedule(task3, 2, TimeUnit.SECONDS);
				executorService.schedule(task4, 1, TimeUnit.SECONDS);
				executorService.schedule(task5, 0, TimeUnit.SECONDS);

		} finally {
			long end = System.currentTimeMillis();
			System.out.println("Evaluated time: " + (end - start));
		}
	}
}

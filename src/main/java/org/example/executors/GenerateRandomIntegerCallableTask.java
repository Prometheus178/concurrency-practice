package org.example.executors;

import java.util.Random;
import java.util.concurrent.Callable;

public class GenerateRandomIntegerCallableTask implements Callable<Integer> {

	private final Random random = new Random();

	@Override
	public Integer call() throws Exception {
		Thread.sleep(100);
		return random.nextInt(1000) + 1;
	}
}

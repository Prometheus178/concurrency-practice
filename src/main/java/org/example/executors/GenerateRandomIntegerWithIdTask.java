package org.example.executors;

import java.util.Random;

public class GenerateRandomIntegerWithIdTask implements Runnable {

	private Integer id;
	private final Random random = new Random();

	public GenerateRandomIntegerWithIdTask(Integer id) {
		this.id = id;
	}

	@Override
	public void run() {
		int randomInt = random.nextInt(1000) + 1;
		System.out.println("SingleThreadPoolTask: ID=" + id + ", value= " + randomInt);
	}
}

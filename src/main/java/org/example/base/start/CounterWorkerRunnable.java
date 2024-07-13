package org.example.base.start;

public class CounterWorkerRunnable implements Runnable {

	private String name;

	private int range;

	public CounterWorkerRunnable(String name, int range) {
		this.name = name;
		this.range = range;
	}

	@Override
	public void run() {
		int counter = 0;
		while (counter <= range) {
			System.out.println(name + ": " + counter++);
		}
	}
}

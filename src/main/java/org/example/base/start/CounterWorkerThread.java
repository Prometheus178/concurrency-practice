package org.example.base.start;

public class CounterWorkerThread extends Thread {

	private String name;

	private int range;

	public CounterWorkerThread(String name, int range) {
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

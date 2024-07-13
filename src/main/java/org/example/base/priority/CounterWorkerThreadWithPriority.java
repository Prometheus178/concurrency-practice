package org.example.base.priority;

public class CounterWorkerThreadWithPriority extends Thread {

	private String name;

	private int range;

	public CounterWorkerThreadWithPriority(String name, int range, int priority) {
		this.name = name;
		this.range = range;
		super.setPriority(priority);
	}

	@Override
	public void run() {
		int counter = 0;
		while (counter <= range) {
			System.out.println(name + ": " + counter++);
		}
	}
}

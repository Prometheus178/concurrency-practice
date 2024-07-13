package org.example.base.daemon;

public class CounterWorkerThreadWithDaemonFlag extends Thread {

	private String name;

	private int range;

	public CounterWorkerThreadWithDaemonFlag(String name, int range, boolean isDaemon) {
		this.name = name;
		this.range = range;
		super.setDaemon(isDaemon);
	}

	@Override
	public void run() {
		int counter = 0;
		while (counter <= range) {
			System.out.println(name + ": " + counter++);
		}
	}
}

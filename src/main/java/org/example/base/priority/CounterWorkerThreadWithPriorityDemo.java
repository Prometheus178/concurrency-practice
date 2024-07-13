package org.example.base.priority;

public class CounterWorkerThreadWithPriorityDemo {

	public static void main(String[] args) {
		System.out.println("Process is started.");

		CounterWorkerThreadWithPriority worker1 = new CounterWorkerThreadWithPriority("A", 10 , 10);
		CounterWorkerThreadWithPriority worker2 = new CounterWorkerThreadWithPriority("B", 10, 1);
		worker1.start();
		worker2.start();

		System.out.println("Process is finished.");
	}
}

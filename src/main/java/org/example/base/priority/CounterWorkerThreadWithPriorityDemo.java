package org.example.base.priority;

/**
 * Priority execution of thread by flag priority. For average a thread  priority is 5
 * The last word about priority of thread on OS
 */
public class CounterWorkerThreadWithPriorityDemo {

	public static void main(String[] args) {
		System.out.println("Process is started.");

		CounterWorkerThreadWithPriority worker1 = new CounterWorkerThreadWithPriority("A", 10, 10);
		CounterWorkerThreadWithPriority worker2 = new CounterWorkerThreadWithPriority("B", 10, 1);
		worker1.start();
		worker2.start();

		System.out.println("Process is finished.");
	}
}

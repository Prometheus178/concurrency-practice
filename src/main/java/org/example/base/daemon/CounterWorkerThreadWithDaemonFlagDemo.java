package org.example.base.daemon;

import org.example.base.priority.CounterWorkerThreadWithPriority;

public class CounterWorkerThreadWithDaemonFlagDemo {

	public static void main(String[] args) {
		System.out.println("Process is started.");

		CounterWorkerThreadWithDaemonFlag worker1 = new CounterWorkerThreadWithDaemonFlag("A", 100 , true);
		CounterWorkerThreadWithDaemonFlag worker2 = new CounterWorkerThreadWithDaemonFlag("B", 10, false);
		worker1.start();
		worker2.start();

		System.out.println("Process is finished.");
	}
}

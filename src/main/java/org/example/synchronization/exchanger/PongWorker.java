package org.example.synchronization.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class PongWorker implements Runnable {

	private final AtomicInteger counter;
	private final Exchanger<AtomicInteger> integerExchanger;

	public PongWorker(AtomicInteger counter, Exchanger<AtomicInteger> integerExchanger) {
		this.counter = counter;
		this.integerExchanger = integerExchanger;
	}

	@Override
	public void run() {
		while (true) {
			try {
				AtomicInteger exchangedCounter = integerExchanger.exchange(counter);
				System.out.println("PONG: " + exchangedCounter.getAndIncrement());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

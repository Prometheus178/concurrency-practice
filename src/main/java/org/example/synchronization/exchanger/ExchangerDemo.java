package org.example.synchronization.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Representation how thread can exchange safely shared data in heap by class Exchanger.
 *  As you can see incrementation can be incremented in the same thread twice or more ,
 *  because thread synchronization should be done by developer
 */
public class ExchangerDemo {

	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger();
		Exchanger<AtomicInteger> integerExchanger = new Exchanger<>();
		PingWorker pingWorker = new PingWorker(counter, integerExchanger);
		PongWorker pongWorker = new PongWorker(counter, integerExchanger);

		Thread thread1 = new Thread(pingWorker);
		Thread thread2 = new Thread(pongWorker);

		thread1.start();
		thread2.start();
	}
}

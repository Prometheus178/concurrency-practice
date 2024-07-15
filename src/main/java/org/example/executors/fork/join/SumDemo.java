package org.example.executors.fork.join;

import java.util.concurrent.ForkJoinPool;

public class SumDemo {

	public static void main(String[] args) {
		int arraySize = 1_000_000;
		int[] array = new int[arraySize];

		fillArray(array);

		long start = System.currentTimeMillis();

		try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
			long calculatedSum = forkJoinPool.invoke(new SumTask(array, 0, array.length));
			System.out.println("Sum= " + calculatedSum);

			long gaussSum = gaussSum(arraySize);
			System.out.println("Gauss sum= " + gaussSum);

			if (calculatedSum == gaussSum) {
				System.out.println("Result is correct");
			}
		} finally {
			long end = System.currentTimeMillis();
			System.out.println("Evaluated time: " + (end - start));
		}
	}


	private static long gaussSum(int n) {
		return (long) n * (n + 1) / 2;
	}

	private static void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
	}

}

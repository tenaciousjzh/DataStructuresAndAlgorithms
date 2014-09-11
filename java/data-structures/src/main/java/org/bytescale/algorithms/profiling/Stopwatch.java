package org.bytescale.algorithms.profiling;

public class Stopwatch {
	private final long startTime;
	private double elapsedTime;
	
	public Stopwatch() {
		startTime = System.currentTimeMillis();
	}
	/**
	 * Returns the elapsed time in seconds
	 * @return
	 */
	public double elapsedTime() {
		long endTime = System.currentTimeMillis();
		elapsedTime = (endTime - startTime) / 1000.0;
		return elapsedTime;
	}
	
	@Override
	public String toString() {
		return "Elapsed Time: " + elapsedTime + " seconds.";
	}
}

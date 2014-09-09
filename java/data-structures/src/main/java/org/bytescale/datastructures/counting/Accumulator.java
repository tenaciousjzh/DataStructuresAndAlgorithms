package org.bytescale.datastructures.counting;

import org.bytescale.datastructures.spec.counting.CountingAccumulator;

public class Accumulator implements CountingAccumulator {
	private double total;
	private int N;
	
	public void addDataValue(double val) {
		N++;
		total += val;
	}
	
	public double mean() {
		return total / N;
	}
	
	@Override
	public String toString() {
		return "Mean (" + N + " values): " + String.format("%7.5f", mean());
	}
}

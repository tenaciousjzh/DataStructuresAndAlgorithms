package org.bytescale.datastructures.counting;

import org.bytescale.datastructures.spec.counting.CountingAccumulator;
import org.bytescale.datastructures.util.StdDraw;

public class VisualAccumulator implements CountingAccumulator {
	private double total;
	private int N;
	
	public VisualAccumulator(int trials, double max) {
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.005);
	}
	
	public void addDataValue(double val) {
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, mean());
	}
	
	public double mean() {
		return total / N;
	}
	
	@Override
	public String toString() {
		return "Mean (" + N + " values): " + String.format("%7.5f", mean());
	}
}

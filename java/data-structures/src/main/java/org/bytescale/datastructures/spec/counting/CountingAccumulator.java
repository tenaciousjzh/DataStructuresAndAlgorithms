package org.bytescale.datastructures.spec.counting;

public interface CountingAccumulator {
	double mean();
	void addDataValue(double val);
}

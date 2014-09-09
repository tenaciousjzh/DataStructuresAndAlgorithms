package org.bytescale.algorithms.counting.clients;

import org.bytescale.datastructures.counting.VisualAccumulator;
import org.bytescale.datastructures.spec.counting.CountingAccumulator;
import org.bytescale.datastructures.util.StdRandom;

public class VisualAccumulatorClient {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		CountingAccumulator a = new VisualAccumulator(T, 1.0);
		for (int t = 0; t < T; t++) {
			a.addDataValue(StdRandom.uniform());
		}
	}
}

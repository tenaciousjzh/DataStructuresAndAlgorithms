package org.bytescale.datastructures.tests.counting;

import static org.junit.Assert.*;

import org.bytescale.datastructures.counting.Accumulator;
import org.bytescale.datastructures.util.StdRandom;
import org.junit.Test;

public class AccumulatorTest {

	@Test
	public void testAccumulator() {
		int T = 76;
		Accumulator a = new Accumulator();
		for (int t = 0; t < T; t++) {
			a.addDataValue(StdRandom.uniform());
		}
		assertTrue(a.toString().length() > 0);
	}
}

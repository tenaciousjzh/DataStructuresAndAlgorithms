package org.bytescale.algorithms.tests.counting;

import static org.junit.Assert.*;

import org.bytescale.algorithms.counting.Counter;
import org.junit.Test;

public class CounterTest {

	@Test
	public void testCounter() {
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		heads.increment();
		int result = heads.tally() - tails.tally();
		assertEquals(1, result);
		assertEquals(heads.tally() + " heads", heads.toString());
	}
}

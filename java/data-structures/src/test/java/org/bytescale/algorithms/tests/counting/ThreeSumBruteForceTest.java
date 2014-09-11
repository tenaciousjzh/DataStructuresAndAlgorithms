package org.bytescale.algorithms.tests.counting;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.bytescale.algorithms.counting.ThreeSumBruteForce;
import org.bytescale.algorithms.profiling.Stopwatch;
import org.bytescale.datastructures.util.In;
import org.junit.Test;

public class ThreeSumBruteForceTest {
	URL location = ThreeSumBruteForceTest.class.getProtectionDomain().getCodeSource().getLocation();
	private String baseFilePath;
	@Test
	public void testThreeSumBruteForce() {
		System.out.println("location = " + location.toString());
		baseFilePath = location.toString().replace("bin/", "") + "src/test/resources/";
		System.out.println("baseFilePath = " + baseFilePath);
		
		Map<Integer,String> testInputs = new HashMap<Integer,String>();
		testInputs.put(new Integer(4), "8ints.txt"); 
		testInputs.put(new Integer(70), "1Kints.txt");
		testInputs.put(new Integer(2), "4Kints.txt");
		testInputs.put(new Integer(32074), "8Kints.txt");

		for (Map.Entry<Integer, String> entry : testInputs.entrySet()) {
			runThreeSumTestOnInput(entry.getValue(), entry.getKey());
		}
	}
	
	private void runThreeSumTestOnInput(String inputFile, int expectedZeroSums) {
		ThreeSumBruteForce ts = new ThreeSumBruteForce();
		In input = new In(baseFilePath + inputFile);
		
		int[] set = input.readAllInts();
		Stopwatch sw = new Stopwatch();
		int zeroSums = ts.countZeroSumTuples(set);
		sw.elapsedTime();
		System.out.println("=======================================")
		System.out.println("Brute Force on " + set.length + " ints");
		System.out.println("Zero Sums found: " + zeroSums);
		System.out.println(sw);
		assertEquals(expectedZeroSums, zeroSums);
	}
}

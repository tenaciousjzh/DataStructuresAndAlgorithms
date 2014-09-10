package org.bytescale.algorithms.tests.counting;

import static org.junit.Assert.*;

import java.net.URL;

import org.bytescale.algorithms.counting.ThreeSumBruteForce;
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
		
		ThreeSumBruteForce ts = new ThreeSumBruteForce();
		In input = new In(baseFilePath + "8ints.txt");
		
		int[] smallSet = input.readAllInts();
		long start = System.currentTimeMillis();
		int zeroSums = ts.countZeroSumTuples(smallSet);
		long end = System.currentTimeMillis();
		long total = end - start;
		System.out.println("Zero Sums found: " + zeroSums);
		System.out.println("Total Time: " + total + "ms");
		int expectedZeroSums = 4;
		assertEquals(expectedZeroSums, zeroSums);
		
		input = new In(baseFilePath + "1Kints.txt");
		int[] oneKSet = input.readAllInts();
		zeroSums = ts.countZeroSumTuples(oneKSet);
		end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Zero Sums found: " + zeroSums);
		System.out.println("Total Time: " + total + "ms");
		expectedZeroSums = 70;
		assertEquals(expectedZeroSums, zeroSums);
		
		input = new In(baseFilePath + "4Kints.txt");
		int[] fourKSet = input.readAllInts();
		zeroSums = ts.countZeroSumTuples(fourKSet);
		end = System.currentTimeMillis();
		total = end - start;
		System.out.println("Zero Sums found: " + zeroSums);
		System.out.println("Total Time: " + total + "ms");
		expectedZeroSums = 2;
		assertEquals(expectedZeroSums, zeroSums);
	}
}

package org.bytescale.algorithms.tests;

import org.apache.commons.io.FilenameUtils;
import org.bytescale.algorithms.counting.ThreeSum;
import org.bytescale.algorithms.counting.ThreeSumBruteForce;
import org.bytescale.algorithms.counting.ThreeSumFast;
import org.bytescale.datastructures.util.In;
import org.bytescale.measurements.StopWatch;
import org.junit.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {
    Map<String, Integer> inputToTupleCount = new HashMap<String, Integer>();

    @Test
    public void testThreeSumOnSmallSet() {
        inputToTupleCount.put("1Kints.txt", 70);

        URL location = ThreeSumTest.class.getProtectionDomain().getCodeSource().getLocation();
        In in = new In(FilenameUtils.concat(location.getPath(), "1Kints.txt"));
        int[] a = in.readAllInts();
        ThreeSum t = new ThreeSumBruteForce();
        t.saveResults(false);

        StopWatch sw = new StopWatch();
        int tupleCount = t.countZeroSumTuples(a);
        double time = sw.elapsedTime();
        System.out.println("Elapsed Time to find " + tupleCount + " tuple(s) whose sum is zero took " + time + " seconds");
        int expectedZeroSumTuples = inputToTupleCount.get("1Kints.txt");
        assertEquals(expectedZeroSumTuples, tupleCount);
    }

    @Test
    public void testThreeSumOnLargeSet() {
        inputToTupleCount.put("1Kints.txt", 70);
        inputToTupleCount.put("8Kints.txt", 32074);
        String inputFile = "8Kints.txt";

        URL location = ThreeSumTest.class.getProtectionDomain().getCodeSource().getLocation();
        In in = new In(FilenameUtils.concat(location.getPath(), inputFile));
        int[] a = in.readAllInts();

        ThreeSum t = new ThreeSumFast();
        t.saveResults(true);

        StopWatch sw = new StopWatch();
        int tupleCount = t.countZeroSumTuples(a);
        double time = sw.elapsedTime();
        System.out.println("Elapsed Time to find " + tupleCount + " tuple(s) whose sum is zero took " + time + " seconds");
        int expectedZeroSumTuples = inputToTupleCount.get(inputFile);

        assertEquals(expectedZeroSumTuples, tupleCount);
    }

    @Test
    public void testThreeSumDoubling() {
        for (int N = 1000; N < 100000; N += N) {
            double time = timeTrial(N);
            System.out.print(" in " + time + " seconds.");
            System.out.println();
        }
    }

    private double timeTrial(int setSize) {
        int MAX = 1000000;
        int a[] = new int[setSize];
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < setSize; i++) {
            int mix = Math.min(-MAX, MAX) + (int)Math.round(-0.5f+(1+Math.abs(-MAX - MAX))*Math.random());
            a[i] = mix;
        }
        StopWatch timer = new StopWatch();
        ThreeSum t = new ThreeSumFast();
        int count = t.countZeroSumTuples(a);
        double time = timer.elapsedTime();
        System.out.print("Found " + count + " tuple(s) in " + setSize + " objects ");
        return time;
    }
}

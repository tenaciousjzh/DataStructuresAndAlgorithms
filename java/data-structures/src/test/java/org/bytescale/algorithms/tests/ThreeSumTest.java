package org.bytescale.algorithms.tests;

import org.apache.commons.io.FilenameUtils;
import org.bytescale.algorithms.ThreeSum;
import org.bytescale.algorithms.Tuple;
import org.bytescale.algorithms.tests.util.In;
import org.bytescale.measurements.StopWatch;
import org.junit.Test;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {
    Map<String, Integer> inputToTupleCount = new HashMap<String, Integer>();

    @Test
    public void testThreeSumOnSmallSet() {
        inputToTupleCount.put("1Kints.txt", 70);

        URL location = ThreeSumTest.class.getProtectionDomain().getCodeSource().getLocation();
        In in = new In(FilenameUtils.concat(location.getPath(), "1Kints.txt"));
        int[] a = in.readAllInts();
        ThreeSum t = new ThreeSum();
        StopWatch sw = new StopWatch();
        Collection<Tuple<Integer>> tuples = t.countZeroSumTuples(a);
        double time = sw.elapsedTime();
        System.out.println("Elapsed Time to find " + tuples.size() + " tuple(s) whose sum is zero took " + time + " milliseconds");
        int expectedZeroSumTuples = inputToTupleCount.get("1Kints.txt");
        assertEquals(expectedZeroSumTuples, tuples.size());
    }

    @Test
    public void testThreeSumOnLargeSet() {
//        URL location = ThreeSumTest.class.getProtectionDomain().getCodeSource().getLocation();
//        In in = new In(FilenameUtils.concat(location.getPath(), "1MInts.txt"));
//        int[] a = in.readAllInts();
//        ThreeSum t = new ThreeSum();
//        StopWatch sw = new StopWatch();
//        Collection<Tuple<Integer>> tuples = t.countZeroSumTuples(a);
//        double time = sw.elapsedTime();
//        System.out.println("Elapsed Time to find " + tuples.size() + " tuple(s) whose sum is zero took " + time + " milliseconds");
//        int expectedZeroSumTuples = 3;
//        assertEquals(expectedZeroSumTuples, tuples.size());
    }
}

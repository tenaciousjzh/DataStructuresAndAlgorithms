package org.bytescale.algorithms.tests;

import org.apache.commons.io.FilenameUtils;
import org.bytescale.algorithms.Pair;
import org.bytescale.algorithms.TwoSum;
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
import static org.junit.Assert.fail;

public class TwoSumTest {
    Map<String, Integer> inputToPairCount = new HashMap<String, Integer>();

    @Test
    public void testTwoSumWithSmallSet() {
        inputToPairCount.put("1Kints.txt", 1);
        inputToPairCount.put("8Kints.txt", 19);
        inputToPairCount.put("1Mintes.txt", 249838);

        String inputFileName = "1Mints.txt";

        URL location = ThreeSumTest.class.getProtectionDomain().getCodeSource().getLocation();
        In in = new In(FilenameUtils.concat(location.getPath(), inputFileName));
        int[] a = in.readAllInts();
        TwoSum ts = new TwoSum();
        StopWatch sw = new StopWatch();
        Collection<Pair<Integer>> pairs = ts.countZeroSumPairs(a);
        double time = sw.elapsedTime();
        System.out.println("Elapsed Time to find " + pairs.size() + " pair(s) whose sum is zero took " + time + " milliseconds");

        int expectedZeroSumPairs = inputToPairCount.get(inputFileName);
        assertEquals(expectedZeroSumPairs, pairs.size());
    }
}

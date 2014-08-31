package org.bytescale.algorithms.tests.search;

import org.bytescale.algorithms.search.BinarySearch;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by Jared on 8/12/14.
 */
public class BinarySearchTest {

    @Test
    public void testRank() {
        int[] whitelist = new int[]{78, 592, 107, 93, 21091, -3, 14, 5124};
        Arrays.sort(whitelist);

        assertTrue(BinarySearch.rank(93, whitelist) > 0);
    }
}

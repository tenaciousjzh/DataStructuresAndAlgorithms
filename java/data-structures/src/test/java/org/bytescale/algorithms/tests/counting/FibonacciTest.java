package org.bytescale.algorithms.tests.counting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jared on 8/22/14.
 */
public class FibonacciTest {

    @Test
    public void testFibonacciCount() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i ++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }

        assertEquals(f, 987);
        //Sedgewick, Robert; Wayne, Kevin (2011-02-21). Algorithms (4th Edition) (Kindle Locations 1281-1282). Pearson Education. Kindle Edition.
    }
}

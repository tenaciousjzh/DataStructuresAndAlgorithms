package org.bytescale.algorithms.tests.transformations;

import org.bytescale.algorithms.transformations.PositiveIntToBinaryString;
import org.junit.Test;

import static org.bytescale.algorithms.transformations.PositiveIntToBinaryString.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Jared on 8/22/14.
 */
public class PositiveIntToBinaryStringTest {

    @Test
    public void testConversion() {
        int N = 1;
        String binaryString = convert(N);
        assertNotNull(binaryString);
        assertEquals(binaryString, "1");

        N = 2;
        binaryString = convert(N);
        assertEquals(binaryString, "10");

        N = 3;
        binaryString = convert(N);
        assertEquals(binaryString, "11");

        N = 8;
        binaryString = convert(N);
        assertEquals(binaryString, "1000");
    }
}

package org.bytescale.datastructures.tests;

import org.bytescale.datastructures.util.maps.SimpleHashTable;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Jared on 1/9/14.
 */
public class SimpleHashTableTest {
    private SimpleHashTable<String, Integer> table;


    @Before
    public void setup() {
        table = new SimpleHashTable<String, Integer>();
    }

    @Test
    public void testPut() {
        loadTableWithRandomValues(11);
        assertEquals(11, table.size());
    }

    private void loadTableWithRandomValues(int howMany) {
        int i = 0;
        Random random = new Random(Calendar.getInstance().getTimeInMillis());

        while (i < howMany) {
            table.put("age" + i, new Integer(random.nextInt()));
            i++;
        }
    }

    @Test
    public void testRemove() {
        loadTableWithRandomValues(5);
        for (int i = 0; i < 5; i++) {
            table.remove("age"+i);
        }
        assertEquals(0, table.size());
    }

    @Test
    public void testContains() {
        loadTableWithRandomValues(11);
        assertTrue(table.contains("age10"));
    }

    @Test
    public void testGet() {
        loadTableWithRandomValues(15);
        assertNotNull(table.get("age14"));
    }
}

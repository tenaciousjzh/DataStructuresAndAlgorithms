package org.bytescale.datastructures.tests;

import org.bytescale.datastructures.util.lists.SimpleLinkedList;
import org.bytescale.datastructures.spec.lists.LinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {
    private LinkedList<String> list;

    @Before
    public void setup() {
        list = new SimpleLinkedList<String>();
    }

    @Test
    public void testAddToSimpleLinkedList() {
        assertEquals(0, list.size());
        list.add("Hello World");
        assertEquals(1, list.size());

        list.add("Another Item");
        list.add("Yet Another Item");
        assertEquals(3, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNull() {
        list.add(null);
    }

    @Test
    public void testRemoveFromSimpleLinkedList() {
        assertEquals(0, list.size());
        String greeting = "Hello World";
        list.add(greeting);
        assertEquals(1, list.size());
        list.remove(greeting);
        assertEquals(0, list.size());

        String localGreeting = "Hey Neighbor";
        list.add(localGreeting);
        String portuguesGreeeting = "Tudo Bem Tche!";
        list.add(portuguesGreeeting);
        list.add(greeting);
        //removes the first item in the list
        list.remove(localGreeting);
        assertEquals(2, list.size());

        //make sure the other greetings weren't lost
        for (String item : list) {
            assertTrue(item.equals(greeting) || item.equals(portuguesGreeeting));
        }

        list.remove(greeting);
        //should only be one left

        for (String item : list) {
            assertTrue(item.equals(portuguesGreeeting));
        }

        assertEquals(1, list.size());

        //now remove something from the middle
        list.add(greeting);
        String spanishGreeting = "Hola!";
        list.add(spanishGreeting);
        list.remove(greeting);

        assertEquals(2, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        list.remove(null);
    }

    @Test
    public void testContains() {
        list.add("abc");
        assertTrue(list.contains("abc"));
    }
}

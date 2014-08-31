package org.bytescale.algorithms.search;

import org.bytescale.datastructures.util.In;
import org.bytescale.datastructures.util.StdIn;

import java.util.Arrays;

/**
 * Created by Jared on 2/1/14.
 */
public class BinarySearch {
    /**
     * Uses binary search algorithm to determine if key provided is in the array.
     * If it is, the index of the key is returned.
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) / 2);
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        if (args[0] == null) {
            throw new IllegalArgumentException("Need to specify the file to search.");
        }
        In in = new In(args[0]);

        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);

        System.out.print("Enter a number to search for: ");

        while (!StdIn.isEmpty()) {
            //Read the key and print if not in whitelist

            int key = StdIn.readInt();
            if (BinarySearch.rank(key, whitelist) == -1) {
                System.out.println("Sorry! Couldn't find " + key + " in the list.");
            } else {
                System.out.println("Found it!");
            }
        }
    }
}

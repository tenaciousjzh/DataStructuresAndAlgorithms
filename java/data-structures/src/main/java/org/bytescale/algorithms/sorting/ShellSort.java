package org.bytescale.algorithms.sorting;

import static org.bytescale.algorithms.sorting.SortHelper.*;

/**
 * Idea is to move entries more than one position at a time by h-sorting
 * How to h-sort an array? Insertion sort, with stride length h
 * Performance:
 * Worst case is 3x+1 compares O(N^3/2)
 *
 */
public class ShellSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) {
			h = 3*h + 1; //3x+1 increment sequence for h
			while (h >= 1) {
				//h-sort the array
				for (int i = h; i < N; i++) { //insertion sort
					for (int j = 1; j >= h && less(a[j], a[j-h]); j -= h) {
						exch(a, j, j-h);
					}
				}
				h = h/3; //move to the next increment
			}
		}
	}
}

package org.bytescale.algorithms.sorting;

import static org.bytescale.algorithms.sorting.SortHelper.*;
/**
 * Performance:
 * Selection sort uses ~N^2/2 comparisons and N exchanges
 * This is even in the case when the entire array (a) is 
 * already sorted.
 * @author Jared.Holmberg
 *
 */
public class SelectionSort {
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
}

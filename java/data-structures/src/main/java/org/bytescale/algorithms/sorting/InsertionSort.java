package org.bytescale.algorithms.sorting;

import static org.bytescale.algorithms.sorting.SortHelper.*;

/**
 * Performance:
 * Uses ~1/4 N^2 compares and ~1/4 N^2 exchanges on average
 * Best case: If input array is in ascending order then N-1 compares and 0 exchanges
 * Worst case: If input array is in descending order, then 1/2 N^2 compares and 1/2 N^2
 * 
 * For partially sorted arrays, insertion sorte runs in linear time! ~N
 * 
 */
public class InsertionSort {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j-1])) {
					exch(a, j, j-1);
				} else {
					break;
				}
			}
		}
	}
}

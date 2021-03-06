package org.bytescale.algorithms.sorting;

public class SortHelper {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	@SuppressWarnings("rawtypes")
	public static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}

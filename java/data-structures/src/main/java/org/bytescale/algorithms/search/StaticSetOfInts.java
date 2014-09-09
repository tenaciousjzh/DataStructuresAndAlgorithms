package org.bytescale.algorithms.search;

import java.util.Arrays;

public class StaticSetOfInts {
	private int[] a;
	
	public StaticSetOfInts(int[] keys) {
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++) {
			a[i] = keys[i];
		}
		Arrays.sort(a);
	}
	
	public boolean contains(int key) {
		return BinarySearch.rank(key, a) != -1;
	}
}

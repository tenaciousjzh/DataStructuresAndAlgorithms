package org.bytescale.algorithms.exercises.ex01;

public class Alg12 {
	/**
	 * What does the following fragment print?
	 */
	public static void main(String[] args) {
		int[] a = new int[10];
		// a[0] = 9-0 = 9
		// a[1] = 9-1 = 8
		// ...
		// a[9] = 9-4 = 0
		for (int i = 0; i < 10; i++) {
			a[i] = 9 - i;
			System.out.println("a[" + i + "] = 9 - " + i + " = " + (9-i));
		}
		System.out.println("===============================================");
		
		// a[0] = a[a[0]] = a[9] = 0
		// a[1] = a[a[1]] = a[8] = 1
		// a[2] = a[a[2]] = a[7] = 2
		// a[9] = a[a[9]] = a[0] = 9
		for (int i = 0; i < 10; i++) {
			int indexVal = a[i];
			System.out.println("a[" + i + "] = a[a[" + i +"]] = " + " a[" + a[indexVal] + "] = " + a[a[i]]);
			a[i] = a[a[i]];
			
		}
		System.out.println("===============================================");

		for (int i = 0; i < 10; i++)
			System.out.println("a[" + i + "] = " + a[i]);
	}
}

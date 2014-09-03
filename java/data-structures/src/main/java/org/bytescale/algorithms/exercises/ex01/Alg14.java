package org.bytescale.algorithms.exercises.ex01;

/**
 * Write a static method lg() that takes an int value N as argument and returns the largest int 
 * not larger than the base-2 logarithm of N. Do not use Math.
 * 
 * Remember: log (8) = 3
 *              2
 * is the same as 2 * 2 * 2 = 8
 *                |---3---| 
 * 2 is the number being multiplied (or the base)
 * 
 * 
 */
public class Alg14 {
	/**
	 * Returns the largest int not larger than the base-2 logarithm of N
	 * @param N
	 * @return
	 */
	public static int lg(int N) {
		if (N < 0) throw new IllegalArgumentException("Must supply a positive integer greater than 0");
		
		int n = N;
		int log = 0;
		int base = 2;
		while (n >= base) {
			n = n / base;
			log++;
		}
		return log;
	}
	
	public static void main(String[] args) {
		System.out.println("lg(8) = the largest int not greater than the base 2 logarithm of the number N supplied as the argument to the lg() function.");
		System.out.println("lg(8) = " + lg(8));
		System.out.println("lg(7) = " + lg(7));
	}
}

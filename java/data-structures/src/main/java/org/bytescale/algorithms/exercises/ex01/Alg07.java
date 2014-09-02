package org.bytescale.algorithms.exercises.ex01;

/**
 * Evaluate the following expressions and indicate what will be output
 * @author Jared.Holmberg
 *
 */
public class Alg07 {
	
	
	public static void main(String[] args) {
		
		//Looks like this will evaluate to 3.000something
		double t = 9.0;
		while (Math.abs(t - 9.0/t) > 0.001) {
			t = (9.0/t + t) / 2.0;
			System.out.println("t = " + t); //confirmed 3.00009
		}
		
		//Looks like this will evaluate to 998
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
			System.out.println("i = " + i + ", sum (current): " + sum);
		}
		System.out.println("sum = " + sum); //actually this is 499,500 
		
		//Outer loop will iterate 10 times (1, 2, 4, 8, 16, 32, 64, 128, 256, 512)
		//Inner loop will iterate 1000 times on each outer loop
		// 1000 * 10 = 10,000
		sum = 0;
		for (int i = 1; i < 1000; i *= 2) {
			for (int j = 0; j < 1000; j++) {
				sum++;
			}
		}
		System.out.println("sum = " + sum); //confirmed 10,000
	}
}

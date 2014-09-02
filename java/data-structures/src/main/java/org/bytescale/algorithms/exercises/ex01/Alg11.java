package org.bytescale.algorithms.exercises.ex01;

/**
 * Write a code fragment that prints out the contents of a 
 * 2 dimensional boolean array, using * to represent the true 
 * and a space to represent false. Include row and column numbers.
 * @author Jared.Holmberg
 *
 */
public class Alg11 {
	public static void printBooleanArray(boolean[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				String booleanSymbol = (array[row][col] == true) ? "*" : " "; 
				System.out.println(String.format("[%d, %d] : %s", row, col, booleanSymbol));
			}
		}
	}
	
	public static void main(String[] args) {
		boolean[][] arr = {
			{true, false},
			{false,true}
		};
		printBooleanArray(arr);
	}
}

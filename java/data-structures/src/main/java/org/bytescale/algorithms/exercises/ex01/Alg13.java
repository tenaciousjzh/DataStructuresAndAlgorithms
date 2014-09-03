package org.bytescale.algorithms.exercises.ex01;

public class Alg13 {
	/**
	 * Example matrix
	 * [
	 * 	[1,2,3], 
	 * 	[4, 17, 9,], 
	 * 	[24, 98, 23], 
	 * 	[-3, -100, 9]
	 * ]
	 * This example matrix has 4 rows, and 3 columns
	 * @param matrix
	 * @return
	 */
	public static int[][] transpose(int[][] matrix) {
		//first find out the rows and columns in the original matrix
		int originalRows = matrix.length;
		int originalCols = matrix[0].length;
		
		int[][] transposed = new int[originalCols][originalRows];
		for (int row = 0; row < originalRows; row++) {
			for (int col = 0; col < originalCols; col++) {
				transposed[col][row] = matrix[row][col];
			}
		}
		return transposed;
	}
	
	public static void printMatrix(int[][] matrix) {
		String newline = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder("");
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (col == 0) {
					sb.append("[");
				} 
				
				sb.append(matrix[row][col]);
				
				if (col < matrix[row].length - 1) {
					sb.append (", ");
				} else {
					sb.append("]");
					sb.append(newline);
				}
			}
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1, 2, 3},
			{4, 17, 9},
			{24, 98, 23},
			{-3, -100, 0}
		};
		System.out.println("Matrix : ");
		printMatrix(matrix);
		int[][] transposedMatrix = transpose(matrix);
		System.out.println("Transposed Matrix: ");
		printMatrix(transposedMatrix);
	}

}

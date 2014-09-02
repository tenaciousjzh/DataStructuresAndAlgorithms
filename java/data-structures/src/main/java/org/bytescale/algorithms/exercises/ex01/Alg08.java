package org.bytescale.algorithms.exercises.ex01;

public class Alg08 {
	/**
	 * What do each of the following print?
	 * @param args
	 */
	public static void main(String[] args) {
		
		//System.out.println('b'); 
		//Should print the character b
		System.out.println('b'); //confirmed 'b'
		
		//System.out.println('b' + 'c');
		//This will convert the ascii 'b' character to its numerical value
		//So this will convert to 98 + 99 = 197
		System.out.println('b' + 'c'); //confirmed 197
		
		//This will convert ascii 'a' characer to its numerical value
		//So this will convert to 98 + 4 = 102
		//The cast back to a char means 104 will convert to the letter 'e'
		System.out.println((char) ('a' + 4)); //confirmed 'e'
	}
}

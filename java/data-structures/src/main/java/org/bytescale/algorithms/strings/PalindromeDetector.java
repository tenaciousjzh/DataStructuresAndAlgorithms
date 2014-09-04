package org.bytescale.algorithms.strings;

public class PalindromeDetector {
	public static boolean isPalindrome(String s) {
		boolean isPalindrome = true;
		int length = s.length();
		
		//You only need to iterate up to the middle of the string
		//to know if it's a palindrome
		for (int i = 0; i < length / 2; i++) {
			char currentChar = s.charAt(i);
			char doppelganger = s.charAt((length - 1) - i);
			if (currentChar != doppelganger) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}
}

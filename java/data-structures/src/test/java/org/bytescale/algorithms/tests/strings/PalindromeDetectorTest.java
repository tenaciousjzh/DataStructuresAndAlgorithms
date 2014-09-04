package org.bytescale.algorithms.tests.strings;

import org.junit.Test;

import static org.bytescale.algorithms.strings.PalindromeDetector.isPalindrome;
import static org.junit.Assert.*;


public class PalindromeDetectorTest {
	
	@Test
	public void testPalindromes() {
		String palindrome = "kayak";
		assertTrue(isPalindrome(palindrome));
		String evenLengthPalindrome = "abba";
		assertTrue(isPalindrome(evenLengthPalindrome));
		String nonPalindrome = "evil";
		assertFalse(isPalindrome(nonPalindrome));
	}
	
}

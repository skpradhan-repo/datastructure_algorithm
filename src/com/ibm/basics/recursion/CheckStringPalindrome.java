/**
 * 
 */
package com.ibm.basics.recursion;

/**
 * @author 004ISA744
 *
 */
public class CheckStringPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome("dabcbad", 0, 6));
	}

	private static boolean isPalindrome(String string, int i, int j) {
		if (i >= j) {
			return true;
		}
		
		else if (string.charAt(i) != string.charAt(j)) {
			return false;
		}
		
		return isPalindrome(string, i+1, j-1);
	}

}

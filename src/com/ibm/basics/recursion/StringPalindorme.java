/**
 * 
 */
package com.ibm.basics.recursion;

/**
 * @author 004ISA744
 *
 */
public class StringPalindorme {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "dad";
		System.out.println(isPalindrome(str, 0, str.length()-1));
	}

	private static boolean isPalindrome(String str, int i, int j) {
		if (i >= j) {
			return true;
		}
		return str.charAt(i) == str.charAt(j) && isPalindrome(str, i+1, j-1);
	}

}

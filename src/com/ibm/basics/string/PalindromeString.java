/**
 * 
 */
package com.ibm.basics.string;

import java.util.Arrays;

/**
 * @author 004ISA744
 *
 */
public class PalindromeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve("adam"));
		System.out.println(solve("madam"));
	}
	
	public static boolean solve(String str) {
		int start = 0;
		int end = str.length()-1;
		
		while(start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start ++;
			end --;
		}
		return true;
	}

}

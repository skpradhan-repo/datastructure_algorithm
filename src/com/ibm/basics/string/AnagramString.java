/**
 * 
 */
package com.ibm.basics.string;

import java.util.Arrays;

/**
 * @author 004ISA744
 *
 */
public class AnagramString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve("REST".toCharArray(),"TESR".toCharArray()));
		System.out.println(solve("REST".toCharArray(),"TEST".toCharArray()));
	}
	
	public static boolean solve(char[] ch1, char[] ch2) {
		if (ch1.length != ch2.length) {
			return false;
		}
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		for (int i = 0; i < ch2.length; i++) {
			if (ch1[i] != ch2[i]) {
				return false;
			}
		}
		
		return true;
	}

}

/**
 * 
 */
package com.ibm.basics.string.pattern.matching;

/**
 * @author 004ISA744
 *
 */
public class PatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve("aabaca".toCharArray(), "baa".toCharArray()));
		System.out.println(solve("This is a test".toCharArray(), "test".toCharArray()));
	}
	
	public static int solve(char[] text, char[] matcher) {
		for (int i = 0; i <= text.length-matcher.length; i++) {
			int j=0;
			for(; j<matcher.length; j++) {
				if(text[i+j] != matcher[j]) {
					break;
				}
			}
			if(j == matcher.length)
				return i;
		}
		
		return -1;
	}

}

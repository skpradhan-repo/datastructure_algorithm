/**
 * 
 */
package com.ibm.basics.recursion;

/**
 * @author 004ISA744
 *
 */
public class ReverseTheNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(0,2475));
		System.out.println(reverse(2475));
	}

	private static int reverse(int result, int input) {
		if (input <= 0) {
			return result;
		}
		
		result = result * 10 + input % 10; 
		
		input = input/10;
		
		return reverse(result, input);
	}
	
	private static int reverse(int input) {
		if (input == 0) {
			return 0;
		}
		int digit = input % 10;
		return digit + reverse(input / 10);
	}

}

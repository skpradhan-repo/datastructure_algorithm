/**
 * 
 */
package com.ibm.basics.number;

/**
 * @author 004ISA744
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve(1234));
	}
	
	public static int solve(int num) {
		int result = 0;
		while(num > 0) {
			result = result*10 + num%10;
			num = num/10;
		}
		
		return result;
	}

}

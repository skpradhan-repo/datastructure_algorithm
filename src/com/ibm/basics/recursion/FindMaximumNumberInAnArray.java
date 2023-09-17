/**
 * 
 */
package com.ibm.basics.recursion;

/**
 * @author 004ISA744
 *
 */
public class FindMaximumNumberInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {4,1,3,6,2,9,6};
		System.out.println(maximum(arr, 6));
	}
	
	public static int maximum(int[] arr, int index) {
		if(index == 0)
			return arr[0];
		
		return Math.max(arr[index], maximum(arr, index-1));
	}

}

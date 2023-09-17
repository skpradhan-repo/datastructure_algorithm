/**
 * 
 */
package com.ibm.basics.recursion;

/**
 * @author 004ISA744
 *
 */
public class IsCorrectNumberSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(isSequencedArray(arr, 0));
	}

	private static boolean isSequencedArray(int[] arr, int i) {
		if(i == arr.length-1) {
			return true;
		}
		
		return arr[i+1] == arr[i]+1 && isSequencedArray(arr, i+1);
	}

}

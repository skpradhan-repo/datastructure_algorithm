/**
 * 
 */
package com.ibm.basics.array;

import java.util.Arrays;

/**
 * @author 004ISA744
 *
 */
public class ReverseArrayInPlace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {12,6,2,1,9,10,3};
		int start = 0;
		int end = arr.length-1;
		
		while(start < end) {
			int temp = arr[end];
			arr [end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

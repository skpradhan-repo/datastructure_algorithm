/**
 * 
 */
package com.ibm.basics.sort;

import java.util.Arrays;

/**
 * @author 004ISA744
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,1,3,4,7,6,5};
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}

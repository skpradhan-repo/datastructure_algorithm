/**
 * 
 */
package com.ibm.basics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 004ISA744
 *
 */
public class TargetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,10};
		List<Integer> partial = new ArrayList<>();
		int start = 0;
		int target = 6;
		int partialSum = 0;
		
		partialSummation(arr, target, partialSum, start, partial);
	}

	private static void partialSummation(int[] arr, int target, int partialSum, int start, List<Integer> partial) {
		if(partialSum == target) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			if (partialSum+arr[i] > target || start >= arr.length && arr[i] == arr[i-1]) {
				continue;
			}
			
			partial.add(arr[i]);
			partialSummation(arr, target, partialSum+arr[i], start+1, partial);
			partial.remove(partial.size()-1);
		}
	}

}

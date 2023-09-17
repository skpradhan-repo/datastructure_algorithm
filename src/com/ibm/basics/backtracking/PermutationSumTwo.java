/**
 * 
 */
package com.ibm.basics.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 004ISA744
 *
 */
public class PermutationSumTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,8};
		permuteAndSum(arr, 8, 0, new HashSet<Integer>(), 0);
	}

	private static void permuteAndSum(int[] arr, int target, int sum, HashSet<Integer> partial, int start) {
		if (sum == target) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			int c = arr[i];
			if (sum + c > target || start > arr.length && arr[i] == arr[i-1]) {
				continue;
			}
			partial.add(c);
			permuteAndSum(arr, target, sum+c, partial, i+1);
			partial.remove(c);
		}
	}

}

/**
 * 
 */
package com.ibm.basics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 004ISA744
 *
 */
public class PermutationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,8};
		List<Integer> partial = new ArrayList<>();
		int sum = 0;
		int start = 0;
		int target = 8;
		permuteSum(arr, target, partial, sum, start);
	}

	private static void permuteSum(int[] arr, int target, List<Integer> partial, int sum, int start) {
		if (sum == target) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		for (int i = start; i < arr.length; i++) {
			int c = arr[i];
			
			if (sum+c > target || (i > start && arr[i] == arr[i-1])) {
				continue;
			}
			partial.add(arr[i]);
			permuteSum(arr, target, partial, sum+c, i+1);
			partial.remove(partial.size()-1);
		}
	}

}

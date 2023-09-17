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
public class SamplePermutationOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 6 };
		boolean[] used = new boolean[arr.length];
		List<Integer> partial = new ArrayList<>();
		permutation(arr, partial, used);
	}

	private static void permutation(int[] arr, List<Integer> partial, boolean[] used) {
		if (partial.size() == arr.length) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!used[i]) {
				used[i] = true;
				partial.add(arr[i]);
				permutation(arr, partial, used);
				used[i] = false;
				partial.remove(partial.size() - 1);
			}
		}
	}

}

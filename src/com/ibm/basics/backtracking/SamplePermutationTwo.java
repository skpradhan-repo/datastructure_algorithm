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
public class SamplePermutationTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5,2,3,7};
		List<Integer> partial = new ArrayList<>();
		permute(arr, partial, 0,3);
	}

	private static void permute(int[] arr, List<Integer> partial, int start, int length) {
		if (partial.size() == length) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		
		if (start >= arr.length) {
			return;
		}
		
		partial.add(arr[start]);
		permute(arr, partial, start+1, length);
		partial.remove((Integer)arr[start]);
		permute(arr, partial, start+1, length);
	}

}

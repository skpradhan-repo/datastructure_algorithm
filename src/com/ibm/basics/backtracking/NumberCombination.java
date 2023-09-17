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
public class NumberCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
//		Set<Integer> partial = new HashSet<>();
		List<Integer> partial = new ArrayList<>();
		partialCombination(nums, partial, 0, 3);
	}

	private static void partialCombination(int[] nums, List<Integer> partial, int i, int len) {
		if (partial.size() == len) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		
		if (i >= nums.length) {
			return;
		}
		
		Integer temp = nums[i];
		partial.add(temp);
		partialCombination(nums, partial, i+1, len);
		partial.remove((Integer)nums[i]);
		partialCombination(nums, partial, i+1, len);
	}

}

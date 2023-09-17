/**
 * 
 */
package com.ibm.basics.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 004ISA744
 *
 */
public class AlternatePermute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {4,5,2,7};
		Set<Integer> partial = new HashSet<>();
		int length = 3;
		int start = 0;
		permute(num, partial, length, start);
	}

	private static void permute(int[] num, Set<Integer> partial, int length, int pos) {
		if (partial.size() == length) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		
		if (pos >= num.length) {
			return;
		}
		
		partial.add(num[pos]);
		permute(num, partial, length, pos+1);
		partial.remove((Integer)num[pos]);
		permute(num, partial, length, pos+1);
	}
}

/**
 * 
 */
package com.ibm.basics.backtracking;

/**
 * @author 004ISA744
 *
 */
public class StringPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Helo";
		permute(str, new StringBuffer(), 0, 3);
	}

	private static void permute(String str, StringBuffer partial, int i, int j) {
		if (partial.length() == j) {
			System.out.println(partial.toString());
			return;
		}
		partial.append(str.charAt(i));
		permute(str, partial, i + 1, j);
		partial.replace(i, i+1, "");
		permute(str, partial, i + 1, j);
	}

}

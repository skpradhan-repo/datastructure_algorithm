/**
 * 
 */
package com.ibm.basics.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 004ISA744
 *
 */
public class StringPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		generatePermutation("", "ABC", result);
		result.forEach(System.out::println);
	}

	public static void generatePermutation(String prefix, String remaining, List<String> result) {
		if (remaining.length() == 0) {
			result.add(prefix);
		}
		for (int i = 0; i < remaining.length(); i++) {
			String newPrefix = prefix+remaining.charAt(i);
			String newRemaining = remaining.substring(0,i)+remaining.substring(i+1);
			generatePermutation(newPrefix, newRemaining, result);
		}
	}

}

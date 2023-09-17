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
public class StringPrefixesAndSuffixes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getPrefixes("hello"));
		System.out.println(getSuffixes("hello"));
	}

	public static List<String> getPrefixes(String str) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			result.add(str.substring(i, str.length()));
		}
		return result;
	}

	public static List<String> getSuffixes(String str) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= str.length(); i++) {
			result.add(str.substring(0, i));
		}
		return result;
	}

}

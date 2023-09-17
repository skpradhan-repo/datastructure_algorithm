/**
 * 
 */
package com.ibm.basics.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 004ISA744
 *
 */
public class LargestPatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> result = getSuffixes("hellohelloeshkhj");
		Collections.sort(result);
		String maxCommonPattern = "";
		for (int i = 0; i < result.size()-1; i++) {
			String str = lcp(result.get(i), result.get(i+1));
			if (str != null && str.length() > maxCommonPattern.length()) {
				maxCommonPattern = str;
			}
		}
		System.out.println(maxCommonPattern);
	}
	
	private static String lcp(String text1, String text2) {
		int minLength = Math.min(text1.length(), text2.length());
		for (int i = 0; i < minLength; i++) {
			if(text1.charAt(i) != text2.charAt(i))
				return text1.substring(0,i);
		}
		return text1.substring(0,minLength);
	}
	
	public static List<String> getSuffixes(String text){
		List<String> result = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			result.add(text.substring(i, text.length()));
		}
		
		return result;
	}

}

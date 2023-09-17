/**
 * 
 */
package com.ibm.basics.stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 004ISA744
 *
 */
public class WordCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Hi Dear, How are you. Hope you are doing well. Shall we meet on coming weekend. Really excited to see you";
		String[] split = str.split("[ .]");
		Arrays.stream(split).filter(i -> !i.isEmpty())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
		System.out.println("========================================");
		Arrays.stream(split).filter(s -> !s.isEmpty()).collect(Collectors.toMap(s -> s, s -> 1L, Long::sum))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
	}

}

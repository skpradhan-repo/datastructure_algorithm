/**
 * 
 */
package com.ibm.basics.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 004ISA744
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = Stream.of("Hello", "World").collect(Collectors.joining(" "));
		System.out.println(result);
	}

}

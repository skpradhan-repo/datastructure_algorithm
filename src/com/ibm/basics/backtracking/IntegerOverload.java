/**
 * 
 */
package com.ibm.basics.backtracking;

/**
 * @author 004ISA744
 *
 */
public class IntegerOverload {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		show((Integer)3);
		show(3);
	}
	
	public static void show(int num) {
		System.out.println("Premitive : "+ num);
	}
	
	public static void show(Integer num) {
		System.out.println("Wrapper : "+num);
	}

}

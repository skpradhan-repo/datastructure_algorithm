/**
 * 
 */
package com.ibm.basics.dp;

/**
 * @author 004ISA744
 *
 */
public class HouseRobber {

	/**
	 * @param args Given that we have a list of houses represented by array indexes
	 *             and each house have some household which is represented by the
	 *             array values. No two consecutive hoses could be searched
	 *             simultaneously. Need to find a way to get the maximum valuables
	 *             from these houses.
	 * 
	 *             At each iteration to the array we need to check the current
	 *             element and current element - 2 values to get the maximum value
	 *             
	 *             The dp array will contain the max value of i and i-2
	 */
	public static void main(String[] args) {
		
		int[] houses = {2, 7, 9, 3, 1};
		
		int length = houses.length;
		
		int[] dp = new int[length];
		
		
		if(length <= 0)
			System.out.println("Array index out of bound");
		
		if (length == 0) {
			System.out.println(houses[0]);
		}
		
		else if(length == 1)
			System.out.println(Math.max(houses[0], houses[1]));
		
		dp[0] = houses[0];
		
		dp[1] = Math.max(houses[0], houses[1]);
		
		for(int i=2; i<dp.length; i++)
			dp[i] = Math.max(dp[i-2]+houses[i], dp[i-1]);
		
		System.out.println(dp[length-1]);
	}

}

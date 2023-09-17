/**
 * 
 */
package com.ibm.basics.dp;

/**
 * @author 004ISA744
 *
 */
public class MinCostPath2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = {{3,12,10,15,10},
						{6,19,7,11,17},
						{8,5,12,32,21},
						{3,20,2,9,7}};
		
//		int[][] grid = {
//	            {1, 3, 1},
//	            {2, 1, 4},
//	            {5, 6, 1}
//	        };
		
		int noOfRow = grid.length;
		int noOfCol = grid[0].length;
		
		int[][] dp = new int[noOfRow][noOfCol];
		
		dp[0][0] = grid[0][0];
		
		// fill the first row
		for (int col = 1; col < noOfCol; col++) {
			dp[0][col] = dp[0][col-1] + grid[0][col];
		}
		
		// fill the first col
		for (int row = 1; row < noOfRow; row++) {
			dp[row][0] = dp[row-1][0] + grid[row][0];
		}
		
		for (int row = 1; row < noOfRow; row++) {
			for (int col = 1; col < noOfCol; col++) {
				dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
			}
		}
		
		System.out.println(dp[noOfRow-1][noOfCol-1]);
	}

}

/**
 * 
 */
package com.ibm.basics.dp;

/**
 * @author 004ISA744
 *
 */
public class MinCostPath1D {

	public static void main(String[] args) {
//        int[][] grid = {
//            {1, 3, 1},
//            {2, 1, 4},
//            {5, 6, 1}
//        };

		int[][] grid = { { 3, 12, 10, 15, 10 }, 
						 { 6, 19, 7, 11, 17 }, 
						 { 8, 5, 12, 32, 21 }, 
						 { 3, 20, 2, 9, 7 } 
					   };

		int[] dp = new int[grid[0].length];
		dp[0] = grid[0][0];

		// For the first row
		for (int row = 1; row < dp.length; row++) {
			dp[row] = dp[row - 1] + grid[0][row];
		}

		// rest of the grid
		for (int row = 1; row < grid.length; row++) {
			dp[0] += grid[row][0];
			for (int col = 1; col < grid[0].length; col++) {
				dp[col] = Math.min(dp[col], dp[col - 1]) + grid[row][col];
			}
		}

		System.out.println(dp[dp.length - 1]);
	}
}

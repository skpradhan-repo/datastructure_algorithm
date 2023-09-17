/**
 * 
 */
package com.ibm.basics.dp;

/**
 * @author 004ISA744
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";

		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];
		
		for (int i = 0; i < n; i++)
			dp[0][i] = 0;

		for (int j = 0; j < m; j++)
			dp[j][0] = 0;


		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[m][n]);
		StringBuffer sb = new StringBuffer();
		for (int i = m; i > 0;) {
			for (int j = n; j > 0; ) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					sb.append(s1.charAt(i-1));
					i--;
					j--;
				}else if(dp[i-1][j] > dp[i][j-1]) {
					i--;
				}else {
					j --;
				}
			}
		}
		
		System.out.println(sb.reverse().toString());
	}
}

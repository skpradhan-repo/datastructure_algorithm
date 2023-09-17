/**
 * 
 */
package com.ibm.basics.dp;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstring {
    public static Set<String> findRepeatedSubstrings(String str) {
        Set<String> repeatedSubstrings = new HashSet<>();
        int n = str.length();

        // Create a 2D array to store the lengths of the longest common substrings
        int[][] dp = new int[n + 1][n + 1];

        // Iterate through the string to find the longest common substrings
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // Check if the current common substring is longer than 1 and not already added
                    if (dp[i][j] > 1 && !repeatedSubstrings.contains(str.substring(i - dp[i][j], i))) {
                        repeatedSubstrings.add(str.substring(i - dp[i][j], i));
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return repeatedSubstrings;
    }

    public static void main(String[] args) {
        String str = "ABABCABABC";
        Set<String> repeatedSubstrings = findRepeatedSubstrings(str);
        System.out.println("Repeated Substrings: " + repeatedSubstrings);
    }
}


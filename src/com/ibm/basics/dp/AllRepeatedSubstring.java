/**
 * 
 */
package com.ibm.basics.dp;

/**
 * @author 004ISA744
 *
 */
import java.util.HashSet;
import java.util.Set;

public class AllRepeatedSubstring {
    public static Set<String> findRepeatedSubstrings(String str) {
        Set<String> repeatedSubstrings = new HashSet<>();
        int n = str.length();

        // Create a set to store encountered substrings
        Set<String> encounteredSubstrings = new HashSet<>();

        // Iterate through different lengths of substrings
        for (int len = 2; len <= n; len++) {
            // Iterate through all possible substrings of length 'len'
            for (int i = 0; i <= n - len; i++) {
                String substring = str.substring(i, i + len);

                // Check if the substring is already encountered
                if (encounteredSubstrings.contains(substring)) {
                    repeatedSubstrings.add(substring);
                } else {
                    encounteredSubstrings.add(substring);
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

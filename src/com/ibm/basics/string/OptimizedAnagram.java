package com.ibm.basics.string;

public class OptimizedAnagram {
	
	public static void main(String[] args) {
		System.out.println(checkAnagram());
	}

	public static boolean checkAnagram() {
		String s1 = "listen";
		String s2 = "silent";
		
		int[] count = new int[26];
		
		if (s1.length() != s2.length()) {
			return false;
		}
		
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)-'a']++;
			count[s2.charAt(i)-'a']--;
		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		
		return true;
		
	}

}

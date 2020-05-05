package week1.day2.assignments.optional;

import java.util.Arrays;

public class Anagram {

	/*
	 * Pseudo Code
	 * 
	 * Declare a String String text1 = "stops"; Declare another String String text2
	 * = "potss"; a) Check length of the strings are same then (Use A Condition) b)
	 * Convert both Strings in to characters c) Sort Both the arrays d) Check both
	 * the arrays has same value
	 * 
	 */
	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potks";
		if (text1.length() == text2.length()) {
			char[] arr1 = text1.toCharArray();
			char[] arr2 = text2.toCharArray();
			Arrays.sort(arr1);
			Arrays.sort(arr2);

			for (int i = 0; i < text1.length(); i++) {
				if (arr1[i] != arr2[i]) {
					System.out.println("Not an Anagram");
					return;
				}
			}
			System.out.println("Anagram");

//			if (Arrays.equals(arr1, arr2)) {
//				System.out.println("Anagram");
//			} else {
//				System.out.println("Not an Anagram");
//			}
		} else {
			System.out.println("Not an Anagram");
		}

	}
}
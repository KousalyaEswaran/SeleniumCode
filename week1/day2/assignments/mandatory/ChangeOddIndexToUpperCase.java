package week1.day2.assignments.mandatory;

import jdk.nashorn.internal.ir.WhileNode;

public class ChangeOddIndexToUpperCase {

	/*
	 * Pseudo Code
	 * 
	 * Declare String Input as Follow
	 * 
	 * String test = "changeme";
	 * 
	 * a) Convert the String to character array
	 * 
	 * b) Traverse through each character (using loop)
	 * 
	 * c)find the odd index within the loop (use mod operator)
	 * 
	 * d)within the loop, change the character to uppercase, if the index is odd
	 * else don't change
	 * 
	 */
	public static void main(String[] args) {
		String test = "changeme";
		char[] arr = test.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 != 0) {
				arr[i] = Character.toUpperCase(arr[i]);
			}
			System.out.print(arr[i]);
		}
	}

}
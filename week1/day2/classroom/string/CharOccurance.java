package week1.day2.classroom.string;

public class CharOccurance {

	public static void main(String[] args) {
		// Check number of occurrences of a char (eg 'e') in a String

		String str = "welcome to chennai";
		char chr = 'e';
		int count = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == chr) {
				count = count + 1;
			}
		}
		System.out.println(count);
		// declare and initialize a variable count to store the number of occurrences

		// convert the string into char array

		// get the length of the array

		// traverse from 0 till the array length

		// Check the char array has the particular char in it

		// if is has increment the count

		// print the count out of the loop

	}

}
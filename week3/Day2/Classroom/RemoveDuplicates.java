package week3.Day2.Classroom;

import java.util.LinkedHashSet;
import java.util.Set;

//Input: "PayPal India"
//Output:ylIndi

public class RemoveDuplicates {

	public static void main(String[] args) {

//		Declare a String as PayPal India

//		Convert it into a character array

//		Declare a Set as charSet for Character

//		Declare a Set as dupCharSet for duplicate Character

//		Iterate character array and add it into charSet

//		if the character is already in the charSet then, add it to the dupCharSet

//		Check the dupCharSet elements and remove those in the charSet

//		Iterate using charSet

//		Check the iterator variable isn't equals to an empty space

//		print each character for charSet

		String s = "PayPal India";
		Boolean b;
		char[] c = s.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();

		for (int i = 0; i < c.length; i++) {
			b = charSet.add(c[i]);
			if (!b) {
				dupCharSet.add(c[i]);
			}
		}
		charSet.removeAll(dupCharSet);
		for (Character character : charSet) {
			if (character != ' ') {
				System.out.print(character);
			}
		}
	}

}

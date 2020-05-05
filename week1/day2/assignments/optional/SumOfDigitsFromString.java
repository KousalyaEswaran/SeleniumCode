package week1.day2.assignments.optional;

public class SumOfDigitsFromString {
	
	

	public static void main(String[] args) {
		String text = "Tes12Le79af65";
		int sum = 0;
		char[] arr = text.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				sum = sum +Character.getNumericValue(arr[i]);
			}
		}
		System.out.println("Sum = " + sum);
	}

}
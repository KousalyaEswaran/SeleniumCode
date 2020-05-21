package week3.Day2.Classroom;

import java.util.Arrays;

public class SortingUsingCollection {
	public static void main(String[] args) {

//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		

//		get the length of the array		

//		sort the array			

//		Iterate it in the reverse order

//		print the array

//		Required Output: Wipro, HCL , CTS, Aspire Systems
		
		String[] company = new String[] {"HCL","Wipro","Aspire Systems", "CTS"};
		int len = company.length;
		Arrays.sort(company);
		
	for (int i = len -1	; i >= 0; i--) {
			System.out.println(company[i]);
		}

	}

}

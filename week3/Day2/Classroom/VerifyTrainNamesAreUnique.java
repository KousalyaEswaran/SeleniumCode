package week3.Day2.Classroom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTrainNamesAreUnique {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * // Set the system property and Launch the URL
		 * 
		 * // Click the 'sort on date' checkbox
		 * 
		 * // clear and type in the from station text field
		 * 
		 * // clear and type in the to station text field
		 * 
		 * // Add a java sleep for 2 seconds
		 * 
		 * // Store all the train names in a list
		 * 
		 * // Get the size of list
		 * 
		 * // Add the list into a new Set
		 * 
		 * // Get the size of set
		 * 
		 * // Compare the Size of list and Set to verify the names are unique
		 */		
		String url = "https://erail.in/";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElementById("chkSelectDateOnly").click();

		driver.findElementByXPath("//input[@id='txtStationFrom']").clear();
		driver.findElementByXPath("//input[@id='txtStationFrom']").sendKeys("MSB", Keys.TAB);

		driver.findElementByXPath("//input[@id='txtStationTo']").clear();
		driver.findElementByXPath("//input[@id='txtStationTo']").sendKeys("SA", Keys.TAB);

		Thread.sleep(10000);

		List<WebElement> rows = driver.findElementsByXPath("//div[@id = 'divTrainsList']/table[1]//tr");
		int rowCount = rows.size();

		List<String> trainNames = new ArrayList<String>();
		for (int i = 1; i <= rowCount; i++) {
			String name = driver.findElementByXPath("//div[@id = 'divTrainsList']/table[1]//tr[" + i + "]/td[2]")
					.getText();
			trainNames.add(name);
		}
		
		System.out.println("No of Train Names in list: "+ trainNames.size());
		
		Set<String> trainSet = new HashSet<String>(trainNames); 
		
		System.out.println("No of Train Names in Set: " + trainSet.size());
		
		if (trainNames.size() == trainSet.size()) {
			System.out.println("Train Names are unique");
		}
		driver.close();
	}

}

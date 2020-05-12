package week2.Day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTwo {

	public static void main(String[] args) throws InterruptedException {

		String url = "http://www.leafground.com/pages/Edit.html";
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); 
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize(); 
		
		driver.findElementById("email").sendKeys("kousalyaeee@gmail.com");
		System.out.println("Email Entered");
		
		driver.findElementByXPath("//input[@value='Append ']").sendKeys("Done" , Keys.TAB);
		System.out.println("Append Done");
		
		String text = driver.findElementByName("username").getAttribute("value");
		System.out.println("Default Text: " + text);
		
		driver.findElementByXPath("//input[@value='Clear me!!']").clear();
		System.out.println("Text Cleared");
		
		System.out.println(driver.findElementByXPath("(//input)[5]").isEnabled());
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}

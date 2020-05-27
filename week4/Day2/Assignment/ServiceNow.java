package week4.Day2.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
//		Launch https://dev60453.service-now.com/
		driver.get("https://dev60453.service-now.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		Login with username as admin and password as India@123
		driver.switchTo().frame("gsft_main");
		
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");		
		driver.findElementById("sysverb_login").click();
		
		
//		Enter Change in filter navigator
		driver.findElementByXPath("//input[@id='filter']").sendKeys("Change",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[text() = 'All'])[4]").click();
		
		Thread.sleep(2000);
//		Click Create New and click Normal change under What type of change is required?
		driver.switchTo().frame("gsft_main");
		driver.findElementById("sysverb_new").click();
		driver.findElementByXPath("//a[contains(text(),'Normal: Changes without predefined plans that require approval and CAB authorization')]").click();
			
//		Capture the change request Number from the Number Filed
		String changeId = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println(changeId);
//		Create new normal Change by filling mandatory fields
		driver.findElementById("change_request.short_description").sendKeys("Test Change");

//		Click submit button
		driver.findElementById("sysverb_insert").click();
		
//		Go to the search field and search the captured number
		driver.findElementById("change_request_table_header_search_control").sendKeys(changeId,Keys.ENTER);
		
//		Verify the successful creation of change 
		boolean displayed = driver.findElementByXPath("//a[text()='"+changeId+"']").isDisplayed();
		if (displayed) {
			System.out.println("Change Request :" + changeId + " got created successfully");
		} else {
			System.out.println("Change Request :" + changeId + " not created successfully");
		}

		Thread.sleep(1000);
		driver.close();

	}

}

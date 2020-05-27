package week4.Day2.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLeads {

	public static void main(String[] args) throws InterruptedException {

//		 Launch URL "http://leaftaps.com/opentaps/control/login"
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
//		Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		 Enter UserName and Password Using Id Locator
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");

//		 Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();

//		 Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();

//	     Click on contacts Button
		driver.findElementByLinkText("Contacts").click();
		
//		 Click on Merge Contacts using Xpath Locator
		driver.findElementByXPath("//a[text() = 'Merge Contacts']").click();
		
//		 Click on Widget of From Contact
		driver.findElementByXPath("//input[@id='partyIdFrom']/following::img[1]").click();
		
//		 Click on First Resulting Contact
		Set<String> windows = driver.getWindowHandles();
		List<String> windowIds = new ArrayList<String>(windows);
		String contactWindow = windowIds.get(1);
		driver.switchTo().window(contactWindow);
		driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[1]//tr/td//a").click();
		
//		 Click on Widget of To Contact
		String mainWindow = windowIds.get(0);
		driver.switchTo().window(mainWindow);
		driver.findElementByXPath("//input[@id='partyIdFrom']/following::img[2]").click();
		
//		 Click on Second Resulting Contact	
		Set<String> window = driver.getWindowHandles();
		List<String> windowId = new ArrayList<String>(window);
		contactWindow = windowId.get(1);
		driver.switchTo().window(contactWindow);
		driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[2]//tr/td//a").click();
		
//		 Click on Merge button using Xpath Locator	 
		driver.switchTo().window(mainWindow);
		driver.findElementByXPath("//a[text()='Merge']").click();
		Thread.sleep(1000);
		
//		 Accept the Alert	
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
//		 Verify the title of the page	
		String title = driver.getTitle();
		
		if (title.contains("Merge Contacts")) {
			System.out.println("Merge Contacts displayed");
		} else {
			System.out.println("Merge Contacts not displayed");
		}

	}

}

package week4.Day1.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().window().maximize();
		
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Actions builder = new Actions(driver);
		WebElement vendors = driver.findElementByXPath("//button[text()=' Vendors']");
		builder.moveToElement(vendors).perform();

		driver.findElementByXPath("//a[text()='Search for Vendor']").click();
		
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		
		List<WebElement> rows = driver.findElementsByXPath("//table//tr");
		
		for (int i = 2; i <= rows.size(); i++) {
			String vendor = driver.findElementByXPath("//table//tr["+ i + "]/td[1]" ).getText();
			
			if (vendor.contains("Blue Lagoon")) {
				String country = driver.findElementByXPath("//table//tr[\"+ i + \"]/td[5]").getText();
				System.out.println(country);
				break;
			}
		}
		
		driver.findElementByLinkText("Log Out").click();
		
		Thread.sleep(2000);
		
		driver.close();

	}

}

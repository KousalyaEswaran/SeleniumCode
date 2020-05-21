package week3.Day2.Assignment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.cleartrip.com/";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElementById("RoundTrip").click();
		driver.findElementById("FromTag").sendKeys("Chennai"  + Keys.TAB);
		driver.findElementById("ToTag").sendKeys("New York" + Keys.TAB);
		driver.findElementById("DepartDate").click();
		driver.findElementByXPath("//a[text() = '24']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//a[text() = '25']").sendKeys(Keys.ENTER);
		
		driver.findElementById("Adults").sendKeys("2");
		driver.findElementById("Childrens").sendKeys("1");
		driver.findElementById("Infants").sendKeys("1");
		
		driver.findElementByXPath("//a[@id = 'MoreOptionsLink']").click();
		driver.findElementById("Class").sendKeys("Premium Economy");
		driver.findElementById("AirlineAutocomplete").sendKeys("Emirates"  + Keys.TAB);
		driver.findElementById("SearchBtn").click();
		
		driver.close();
				
	}

}

package week3.Day2.Assignment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.redbus.in/";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get(url);

		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElementByXPath("//input[@id = 'src']").sendKeys("Chennai");
		Thread.sleep(500);
		driver.findElementByXPath("//input[@id = 'src']").sendKeys(Keys.ENTER);

		driver.findElementById("dest").sendKeys("Salem");
		Thread.sleep(500);
		driver.findElementById("dest").sendKeys(Keys.ENTER);

		driver.findElementByXPath("//label[@for = 'onward_cal']").click();
		driver.findElementByXPath("//div[@class='rb-calendar']//td[@class='current day']").click();

		Thread.sleep(500);
		driver.findElementByXPath("//label[@for = 'return_cal']").click();
		
		driver.findElementByXPath("//div[@class='rb-calendar']//td[text() = '22']").click();
		
		driver.findElementById("search_btn").click();
		
		Thread.sleep(1000);
		
		String text = driver.findElementByXPath("//h3").getText();
		if (text.contains("No buses found")) {
			System.out.println("No buses found");
		}
		driver.close();
	}

}

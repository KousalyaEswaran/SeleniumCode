package week4.Day1.Classroom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();

		WebElement menFashion = driver.findElementByXPath("//li[@class = 'navlink lnHeight' and @navindex = '6']");

		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).perform();
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[text() = 'Shirts'])[2]").click();

		WebElement first = driver.findElementByXPath("//span[contains(@id,'display-price')]");
		builder.moveToElement(first).perform();

		driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();
		Thread.sleep(2000);
		driver.close();
	}
}

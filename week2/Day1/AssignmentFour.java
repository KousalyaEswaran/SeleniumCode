package week2.Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFour {

	public static void main(String[] args) throws InterruptedException {
		String url = "http://www.leafground.com/pages/Link.html";
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();

		driver.findElementByLinkText("Go to Home Page").click();
		System.out.println("Successfully navigated to " + driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);

		String attribute = driver.findElementByPartialLinkText("Find where am supposed to go").getAttribute("href");
		System.out.println("Link will navigate to " + attribute + " Page");

		driver.findElementByPartialLinkText("Verify").click();
		String error = driver.getTitle();
		if (error.contains("404")) {
			System.out.println("Link is broken. Error: " + error);
		} else {
			System.out.println("Link is not broken");
		}
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);

		driver.findElementByXPath("(//a[text() = 'Go to Home Page'])[2]").click();
		System.out.println("Clicked second link");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + allLinks.size());

		driver.close();
	}

}

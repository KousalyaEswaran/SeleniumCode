package week4.Day1.Classroom;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Disappear {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/disapper.html");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElementById("btn")));

		String text = driver.findElementByXPath("//div[@id = 'show']//strong").getText();
		
		System.out.println(text);
		
		driver.close();

	}
}

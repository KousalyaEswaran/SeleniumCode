package week4.Day1.Classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextChange {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/TextChange.html");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));

		driver.findElementById("btn").click();
		
		driver.close();

	}
}

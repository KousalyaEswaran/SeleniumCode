package week4.Day2.Classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class Classroom1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Kousalya");
		alert.accept();

		String text = driver.findElementById("demo").getText();

		if (text.contains("Kousalya")) {
			System.out.println("Name present");
		} else {
			System.out.println("Name not present");
		}

		driver.close();
	}

}

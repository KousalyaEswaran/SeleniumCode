package week4.Day2.Classroom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Classroom3 {

	public static void main(String[] args) throws IOException {
//		 Load https://www.irctc.co.in/nget/train-search

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		 Click Ok for the alert 
		driver.findElementByXPath("//button[text()='Ok']").click();

//		 Click on FLIGHTS link 
		driver.findElementByXPath("//a[text() = ' FLIGHTS ']").click();

//		 Go to the Flights window	-- 
		Set<String> windows = driver.getWindowHandles();
		List<String> windowIds = new ArrayList<String>(windows);
		for (int i = 0; i < windowIds.size(); i++) {
			
		}
		String flightWindow = windowIds.get(1);
		driver.switchTo().window(flightWindow);

//		 Select the "I have read the guidelines"
		WebElement agree = driver.findElementByXPath("//input[@id='agree']");
		Actions builder = new Actions(driver);
		builder.click(agree).perform();
		
//		 Click on Continue
		driver.findElementByXPath("//button[text()='Continue ']").click();

//		 take screenShot of Flights window
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/Classroom3.png");
		FileUtils.copyFile(source, target);

//		 Close the first window (Train eTicketing) alone
		driver.close();
		String trainWindow = windowIds.get(0);
		driver.switchTo().window(trainWindow);
		driver.close();

	}

}

package week4.Day1.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

//		Open https://www.myntra.com/
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

//		Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//		Mouse over on WOMEN
		Actions builder = new Actions(driver);
		WebElement women = driver.findElementByXPath("//a[text()='Women']");
		builder.moveToElement(women).perform();

//		Click Jackets & Coats
		driver.findElementByXPath("//a[text() = 'Jackets & Coats']").click();

//		Find the total count of item 
		String titleCount = driver.findElementByXPath("//span[@class = 'title-count']").getText().replaceAll("[^0-9]",
				"");
		int count = 0;
//		Validate the sum of categories count matches
		List<WebElement> categoryList = driver.findElementsByXPath("//span[@class = 'categories-num']");
		for (int i = 0; i < categoryList.size(); i++) {
			int temp = Integer.parseInt(categoryList.get(i).getText().replaceAll("[^0-9]", ""));
			count = count + temp;
		}
		
		if (Integer.parseInt(titleCount) == count) {
			System.out.println("Count Matched: "+ count);
		} else {
			System.out.println("Count not Matched: "+ count);
		}
		driver.close();

	}

}

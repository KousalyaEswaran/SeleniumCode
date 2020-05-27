package week4.Day2.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
//		Go to https://www.nykaa.com/
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Mouseover on Brands and Mouseover on Popular
		WebElement  brands = driver.findElementByXPath("//a[text() = 'brands']");
		WebElement popular = driver.findElementByXPath("//a[text() = 'Popular']");
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		builder.moveToElement(popular).perform();
		
//		Click L'Oreal Paris
		driver.findElementByXPath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']").click();
		
//		Go to the newly opened window, check the Page title contains L'Oreal Paris and close the first window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		String title = driver.getTitle();
		if (title.contains("L'Oreal Paris")) {
			driver.switchTo().window(handles.get(0));
			driver.close();
		}		
		driver.switchTo().window(handles.get(1));
		
//		Click sort By and select customer top rated
		driver.findElementByXPath("//span[text()='popularity']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(2000);
		
//		Click Category and click Shampoo
		driver.findElementByXPath("//div[text() = 'Category']").click();
		driver.findElementByXPath("//span[contains(text(),'Shampoo')]/following::div").click();
		
//		Click the first listed item
		driver.findElementByXPath("//div[@class = 'm-content__product-list__title'] ").click();
		
//		GO to the new window and click add to bag
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> handles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(handles2.get(1));
		driver.findElementByXPath("//div[@class = 'pull-left']//button").click();
		
//		Go to Shopping Bag and click Proceed
		driver.findElementByXPath("//div[@class = 'AddBagIcon']").click();
		driver.findElementByXPath("//span[contains(text(),'Proceed')]/parent::button").click();
		
//		Print the error message and Close the browser
		String text = driver.findElementByXPath("//div[@class='popup-error']").getText();
		System.out.println(text);

		driver.close();
		driver.switchTo().window(handles2.get(0));
		driver.close();
	}

}

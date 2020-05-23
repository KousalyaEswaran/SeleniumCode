package week4.Day1.Classroom;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);

		WebElement item1 = driver.findElementByXPath("//li[text() = 'Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text() = 'Item 4']");

		Point location = item4.getLocation();
		int xloc = location.getX();
		int yloc = location.getY();

		Actions builder = new Actions(driver);
		builder.clickAndHold(item1).moveToElement(item1, xloc, yloc).release().perform();

		Thread.sleep(3000);

		driver.close();

	}

}

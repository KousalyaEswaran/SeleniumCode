package week2.Day2.Assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) {
		String[] language = {"Java","VB","C"};

		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		for (int i = 0; i < language.length; i++) {
			if (language[i].equalsIgnoreCase("Java")) {
				driver.findElementByXPath("(//label[contains(text(),'Select the languages')]/parent::div//input)[1]").click();
			} else if (language[i].equalsIgnoreCase("VB")) {
				driver.findElementByXPath("(//label[contains(text(),'Select the languages')]/parent::div//input)[2]").click();
			}else if (language[i].equalsIgnoreCase("SQL")) {
				driver.findElementByXPath("(//label[contains(text(),'Select the languages')]/parent::div//input)[3]").click();
			}else if (language[i].equalsIgnoreCase("C")) {
				driver.findElementByXPath("(//label[contains(text(),'Select the languages')]/parent::div//input)[4]").click();
			}else if (language[i].equalsIgnoreCase("C++")) {
				driver.findElementByXPath("(//label[contains(text(),'Select the languages')]/parent::div//input)[5]").click();
			}
		}
		
		WebElement confirm = driver.findElementByXPath("//label[text()='Confirm Selenium is checked']/following::input");
		if (confirm.isSelected()) {
			System.out.println("Selenium option is selected");
		} else {
			System.out.println("Selenium option is not selected");
		}

		List<WebElement> deselect = driver
				.findElementsByXPath("//label[contains(text(),'DeSelect ')]/parent::div//input");
		for (WebElement sAll : deselect) {
			if (sAll.isSelected()) {
				sAll.click();
			}
		}

		List<WebElement> selectAll = driver
				.findElementsByXPath("//label[contains(text(),'Select all')]/parent::div//input");
		for (WebElement sAll : selectAll) {
			sAll.click();
		}
		
		driver.close();
	}

}

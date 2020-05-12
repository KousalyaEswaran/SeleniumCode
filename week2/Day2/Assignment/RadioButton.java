package week2.Day2.Assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		String choice = "Yes";
		int age = 70;

		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();

		if (choice.equalsIgnoreCase("yes")) {
			driver.findElementByXPath("//div[@id = 'first']//input[@id='yes']").click();
		} else {
			driver.findElementByXPath("//div[@id = 'first']//input[@id='no']").click();
		}
		System.out.println("Option " + choice + " is selected");

//		List<WebElement> rbs = driver.findElementsByXPath("//label[contains(text(),'Find default')]/parent::div//input");
//
//		for (WebElement webElement : rbs) {
//			if (webElement.isSelected()) {
//				System.out.println("Selected" + webElement.getAttribute("checked"));
//			}
//		}

		WebElement selected = driver.findElementByXPath(
				"//label[contains(text(),'Find default')]/parent::div//input[@checked]/parent::label");
		System.out.println("Default Option: " + selected.getAttribute("for"));

		List<WebElement> options = driver
				.findElementsByXPath("//label[contains(text(),'Select your age ')]/following-sibling::input");
		if (age > 0 && age <= 20) {
			if (!options.get(0).isSelected()) {
				options.get(0).click();
			}

			System.out.println("Selected 1-20 years");
		} else if (age > 40) {
			if (!options.get(2).isSelected()) {
				options.get(2).click();
			}
			System.out.println("Selected Above 40 years");
		} else {
			if (!options.get(1).isSelected()) {
				options.get(1).click();
			}
			System.out.println("Selected 21-40 years");
		}

		Thread.sleep(2000);

		driver.close();

	}

}

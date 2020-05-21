package week3.Day2.Classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://erail.in/";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElementById("chkSelectDateOnly").click();

		driver.findElementByXPath("//input[@id='txtStationFrom']").clear();
		driver.findElementByXPath("//input[@id='txtStationFrom']").sendKeys("MSB", Keys.TAB);

		driver.findElementByXPath("//input[@id='txtStationTo']").clear();
		driver.findElementByXPath("//input[@id='txtStationTo']").sendKeys("SA", Keys.TAB);

		Thread.sleep(10000);

		List<WebElement> rows = driver.findElementsByXPath("//div[@id = 'divTrainsList']/table[1]//tr");
		int rowCount = rows.size();

		System.out.println(rowCount);

		List<String> trainNames = new ArrayList<String>();
		for (int i = 1; i <= rowCount; i++) {
			String name = driver.findElementByXPath("//div[@id = 'divTrainsList']/table[1]//tr[" + i + "]/td[2]")
					.getText();
			trainNames.add(name);
		}

		Collections.sort(trainNames);
		for (String string : trainNames) {
			System.out.println(string);
		}

		driver.close();

	}

}

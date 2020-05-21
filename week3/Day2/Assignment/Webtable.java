package week3.Day2.Assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		int row = 2;
		int max = 100;
		
		String url = "http://www.leafground.com/pages/table.html";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(500);
		
		List<WebElement> rows = driver.findElementsByXPath("//table[@id='table_id']//tr");
		System.out.println("No of Rows: " + rows.size());
		
		List<WebElement> cols = driver.findElementsByXPath("//table[@id='table_id']//tr[2]/td");
		System.out.println("No of Column: " +cols.size());
		
		String text = driver
				.findElementByXPath("//table[@id='table_id']//tr/td[text()='Learn to interact with Elements']/following-sibling::td").getText();
		System.out.println(text);
		
		for (int i = 2; i <= rows.size(); i++) {
			String progress = driver.findElementByXPath("//table[@id='table_id']//tr[" + i + "]/td[2]").getText();
			
			int temp = Integer.parseInt(progress.substring(0, progress.length()-1));
			if (temp < max) {
				System.out.println(temp);
				row = i;
				max = temp;
			}
		}
		driver.findElementByXPath("//table[@id='table_id']//tr["+row+"]/td[3]/input").click();

		driver.close();
	}

}

package week2.Day2.Assignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();

		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByName("phoneNumber").sendKeys("99");

		driver.findElementByXPath("//button[text() = 'Find Leads']").click();

		Thread.sleep(1000);

		String id = driver.findElementByXPath("//table[@class= 'x-grid3-row-table']//a").getText();
		System.out.println(id);

		driver.findElementByLinkText(id).click();

		driver.findElementByLinkText("Delete").click();

		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(id);

		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(1000);

		String text = driver.findElementByXPath("//div[@class='x-paging-info']").getText();

		if (text.contains("No records to display")) {
			System.out.println("No records to display");
		} else {
			System.out.println("Record not got deleted");
		}

		driver.close();

	}

}

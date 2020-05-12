package week2.Day2.Assignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

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

		Thread.sleep(1000);
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByName("emailAddress").sendKeys("kousalya");

		driver.findElementByXPath("//button[text() = 'Find Leads']").click();

		Thread.sleep(1000);

		String id = driver.findElementByXPath("//table[@class= 'x-grid3-row-table']//a").getText();
		System.out.println(id);

		driver.findElementByLinkText(id).click();
		
		String firstName = driver.findElementById("viewLead_firstName_sp").getText();
//		System.out.println(firstName);
		
		driver.findElementByLinkText("Duplicate Lead").click();
		
		String title = driver.getTitle();
		
		if (title.contains("Duplicate Lead")) {
			System.out.println("Duplicate Lead Tab opened successfully");
		} else {
			System.out.println("Duplicate Lead Tab not opened successfully");
		}
		
		
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		
		Thread.sleep(1000);
		
		String UpdatedName = driver.findElementById("viewLead_firstName_sp").getText();

		if (UpdatedName.equalsIgnoreCase(firstName)) {
			System.out.println("Duplicated Lead successfully");
		} else {
			System.out.println("Duplicate not successfull");
		}
		
		driver.close();

	}

}

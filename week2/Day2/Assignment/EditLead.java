package week2.Day2.Assignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

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
		driver.findElementByXPath("(//input[@name= 'firstName'])[3]").sendKeys("Kousalya");

		driver.findElementByXPath("//button[text() = 'Find Leads']").click();

		Thread.sleep(1000);

		String id = driver.findElementByXPath("//table[@class= 'x-grid3-row-table']//a").getText();
		System.out.println(id);

		driver.findElementByLinkText(id).click();

		System.out.println("Title: " + driver.getTitle());

		driver.findElementByLinkText("Edit").click();

		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("Accenture_U");
		driver.findElementByXPath("//input[@value='Update']").click();

		String text = driver.findElementById("viewLead_companyName_sp").getText();

		if (text.contains("Accenture_U")) {
			System.out.println("Company Name got updated successfully. Company: " + text);
		} else {
			System.out.println("Company Name not got updated successfully. Company: " + text);
		}

		driver.close();

	}

}

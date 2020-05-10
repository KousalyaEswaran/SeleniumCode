package week2.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentOne {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();

		driver.findElementById("createLeadForm_companyName").sendKeys("Accenture");
		driver.findElementById("createLeadForm_firstName").sendKeys("Kousalya");
		driver.findElementById("createLeadForm_lastName").sendKeys("Kaviarasu");

		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select s = new Select(source);
		s.selectByVisibleText("Employee");
		
		WebElement marketingCampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select mc = new Select(marketingCampaign);
		mc.selectByValue("9001");
		
		WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");
		Select o = new Select(ownership);
		o.selectByIndex(5);
		
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select c = new Select(country);
		c.selectByVisibleText("India");

		driver.findElementByClassName("smallSubmit").click();
		
		System.out.println("Title: " + driver.findElementById("sectionHeaderTitle_leads").getText());
//		driver.close();

	}

}

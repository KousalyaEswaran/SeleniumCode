package week2.Day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentThree {
	public static void main(String[] args) throws InterruptedException {

		String url = "http://www.leafground.com/pages/Button.html";
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		
		driver.findElementById("home").click();
		System.out.println("Go to Home Page Button clicked");
		driver.navigate().back();
		
		int xPosition = driver.findElementById("position").getLocation().getX();
		int yPosition = driver.findElementById("position").getLocation().getY();
		
		System.out.println("X :" + xPosition + " Y : "+ yPosition);
		
		String color = driver.findElementById("color").getCssValue("color");
		System.out.println("Color: " + color);
		
		System.out.println(driver.findElementById("color").getAttribute("style"));
		
		int height = driver.findElementById("size").getSize().getHeight();
		int width = driver.findElementById("size").getSize().getWidth();
		
		System.out.println("Height : " + height + " Width : "+ width);
		
		driver.close();

	}
}

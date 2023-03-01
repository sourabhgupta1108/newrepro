package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Testing {

	WebDriver driver;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\sourabh\\testing12\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
	}
	
	@Test
	public void mainPageTitle() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		
	}
	
	@Test
	public void hotelTitle() throws InterruptedException {
		WebElement hotelOption = driver.findElement(By.cssSelector("[class=\"menu_Hotels\"]"));
		hotelOption.click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.makemytrip.com/hotels/");
	}
	
	@AfterMethod
	public void after() {
		driver.quit();
	}
}

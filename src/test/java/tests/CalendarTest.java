package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalendarTest {

	WebDriver driver;
	
	@Test
	public void Calendar() {    

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Open the URL
		driver.get("https://www.cleartrip.com/");   
		
		//Click on Departed Date
		driver.findElement(By.id("DepartDate")).click();
		
		while(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div")).getText().contains("April"))
		{
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
		}
		
		//Select 30 April 2020 
	    // Grab the common attribute and put it into list
		List<WebElement> dates = driver.findElements(By.className("undefined"));
		
		int count = driver.findElements(By.className("undefined")).size();
		
		for(int i = 0; i<count; i++)
		{
			String text = driver.findElements(By.className("undefined")).get(i).getText();
			if(text.equalsIgnoreCase("30"))
			{
				driver.findElements(By.className("undefined")).get(i).click();
				break;
			}
		}
   }
}
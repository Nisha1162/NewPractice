package com.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest3 {
	@Test
	public void testclearTrip() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.00.03\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement from=driver.findElement(By.xpath("//*[@id='FromTag']"));
		Actions act1 = new Actions(driver);
		act1.keyDown(from, Keys.SHIFT).sendKeys("h").perform();
		Thread.sleep(3000);
		act1.keyUp(Keys.SHIFT).perform();
		Thread.sleep(5000);
		act1.sendKeys("yd").perform();
		Thread.sleep(5000);
		act1.sendKeys(Keys.ENTER).perform();
		
		String city = driver.findElement(By.id("From")).getAttribute("Value");
		System.out.println(city);
		Assert.assertEquals(city, "HYD");
		
		WebElement to=driver.findElement(By.id("ToTag"));
		to.sendKeys("ban");
		
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		List <WebElement> list=ul.findElements(By.tagName("li"));
		Assert.assertEquals(list.size(), 10);
		
		for(WebElement e:list)
		{
		String ci=e.getText();
		if(ci.contains("BKK"))
		{
			e.click();
			break;
			
		}
		}
		
		
		
		 
		
	}

}

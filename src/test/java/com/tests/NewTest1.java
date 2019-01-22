package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
	@Test
	
	public void testHDFCbanklinks() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.00.03\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://www.hdfcbank.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		driver.findElement(By.cssSelector("a[href='/personal/products']")).click();
//		driver.findElement(By.cssSelector("a[href='/personal/products/cards']")).click();
//		driver.findElement(By.cssSelector("a[href='/personal/products/cards/credit_cards']")).click();
		
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).perform();	
		Thread.sleep(3000);
		act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[href='/personal/products/cards/credit_cards']")).click();
		Assert.assertTrue(driver.getCurrentUrl().endsWith("credit_cards"));
		driver.close();
		
	}

}

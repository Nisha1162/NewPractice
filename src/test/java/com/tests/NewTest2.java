package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest2 {

	@Test
	public void testAJAXcontrols() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.00.03\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		WebElement from=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[2]/div/div"));
		WebElement to=driver.findElement(By.xpath ("//*[@id=\"ctl00_ContentPlaceholder1_priceChecker\"]"));
		
		Actions act1=new Actions(driver);
//		act1.clickAndHold()
		act1.dragAndDrop(from, to).perform();
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "drop a package here to check price"));
		String text=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println(text);
//		Assert.assertTrue(text.contains("$4999"));
		
	}
	
	
}

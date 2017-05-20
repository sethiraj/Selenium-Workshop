package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ListgroupExample {
	
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	 @BeforeTest
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	    baseUrl = "http://www.seleniumeasy.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    }
	 
	 @AfterTest
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	 }
	 
	 @Test
	 public void testListGroup()
	 {
		 driver.navigate().to("http://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");
		 driver.findElement(By.xpath("(//input[@name='SearchDualList'])[2]")).sendKeys("Cras justo odio");
		 
		 Assert.assertTrue(driver.findElement(By.xpath("//*[@class='list-group-item']")).isDisplayed());
	 }

}

package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class WebdriverWaitExamples {
	
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
	 public void testWebdriverWait()
	 {
			 driver.navigate().to("http://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
			 
			 driver.findElement(By.id("cricle-btn")).click();
			 
			 WebElement downloadPercent = driver.findElement(By.xpath("//div[@class='percenttext']"));
			 WebDriverWait wait = new WebDriverWait(driver, 2000);
			 wait.until(ExpectedConditions.textToBePresentInElement(downloadPercent, "100%"));
			 
			 org.testng.Assert.assertTrue(downloadPercent.getText().equals("100%"));
	 }
}

package com.example.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RealTimeExample {

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
	 public void testRealTimeExample()
	 {
		 driver.navigate().to("http://www.mhadvocates.ae/");
		 driver.findElement(By.xpath("//a[@title='Download Our E-brochure']")).click();
		 
		 File downloadFile = new File("C:/Users/xpanxion/Downloads/brochure.pdf");
		 int counter = 1;
		 int flag = 0;
		 while(!downloadFile.exists())
		 {
			 if(counter == 50000)
			 {
				 //Assert.fail("The File is not downloaded within the specific time limit");
				 flag = 1;
				 break;
			 } 
			 counter++;
		 }
		 
		 if(flag == 1)
			 Assert.fail("The download has been timed out");
	 }	
}
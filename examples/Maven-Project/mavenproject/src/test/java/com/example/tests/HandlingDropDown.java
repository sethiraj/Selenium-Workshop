package com.example.tests;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingDropDown {
	
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
	 
	 @Test(enabled = true)
	 public void testDropDown()
	 {
		 driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		 
		 Select select = new Select(driver.findElement(By.id("select-demo")));
		 select.selectByValue("Sunday");
		 
		 Assert.assertTrue(driver.findElement(By.xpath("//*[@class='selected-value']")).getText().contains("Sunday"));
	 }
	 
	 @Test
	 public void testMultiSelect()
	 {
		 driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		 
		 Select select = new Select(driver.findElement(By.id("multi-select")));
		 select.selectByIndex(1);
		 select.selectByIndex(2);
		 
		 List<WebElement> selectedOptions = select.getAllSelectedOptions();
		 
		 System.out.println(selectedOptions.size());
		 
		 Assert.assertTrue(selectedOptions.size() == 2);
		 Assert.assertTrue(selectedOptions.get(0).getText().equals("Florida"));
	 }

}

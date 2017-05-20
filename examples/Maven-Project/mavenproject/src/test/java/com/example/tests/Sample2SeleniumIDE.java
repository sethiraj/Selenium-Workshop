package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sample2SeleniumIDE {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "http://www.seleniumeasy.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    System.out.println("Step 1: This statement should be executed before test");
  }

  @Test
  public void testSample2SeleniumIDE() throws Exception {
    driver.get(baseUrl + "/test/basic-first-form-demo.html");
    driver.findElement(By.id("user-message")).clear();
    driver.findElement(By.id("user-message")).sendKeys("Trying to learn selenium");
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    driver.findElement(By.id("sum1")).clear();
    driver.findElement(By.id("sum1")).sendKeys("45");
    driver.findElement(By.id("sum2")).clear();
    driver.findElement(By.id("sum2")).sendKeys("55");
    driver.findElement(By.cssSelector("#gettotal > button.btn.btn-default")).click();
    try {
      assertEquals("100", driver.findElement(By.id("displayvalue")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("100", driver.findElement(By.id("displayvalue")).getText());
    System.out.println("Step2: This statement is after successful completion of test");
  }

 @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
    System.out.println("Step3: This is post test");
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
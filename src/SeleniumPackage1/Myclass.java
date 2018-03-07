package SeleniumPackage1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Myclass {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  

	  //System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.10.0-win64\\geckodriver.exe");

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Data\\2017\\Selenium Tests\\Geckodriver\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.facebook.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testFBlogin1() throws Exception {
	    driver.get("https://www.facebook.com");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("optimas@techgeek.co.in");
	    driver.findElement(By.id("pass")).clear();
	    driver.findElement(By.id("pass")).sendKeys("TECHmachagile278*$");
	    driver.findElement(By.id("loginbutton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id=\"userNavigationLabel\"]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//*[@id=\"userNavigationLabel\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath("/html/body/div[23]/div/div/div/div/div[1]/div/div/ul/li[12]/a/span/span"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("/html/body/div[23]/div/div/div/div/div[1]/div/div/ul/li[12]/a/span/span")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
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

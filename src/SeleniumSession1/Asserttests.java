package SeleniumSession1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Asserttests extends OpenCloseBrowser
{
	@Test (enabled =true, groups={"Grouping2"})
	public void AssertPass()
	{
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		int framesize = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of frames = "+ framesize);
		
		WebElement Item1 = driver.findElement(By.xpath("//*[@id='sortable']/li[text()='Item 1']"));
		Assert.assertTrue(Item1.isEnabled());
		Assert.assertTrue(Item1.isDisplayed());
		
		/*Assert.assertFalse(Item1.isEnabled(), "Is Enabled is true");
		Assert.assertFalse(Item1.isDisplayed(), "Is Displayed is true");*/
		
		Actions action1 = new Actions(driver);
		action1.dragAndDropBy(Item1, 0, 150).build().perform();
		Reporter.log("Testing reports");
	}
	@Test(groups ={"Grouping2"})
	@Parameters({"Stest1", "Stest2"})
	public void dataparam(String Stest1, String Stest2)
	{
		System.out.println("String 1 = "+ Stest1);
		System.out.println("String 2 = "+ Stest2);
	}
}

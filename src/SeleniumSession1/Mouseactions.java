package SeleniumSession1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Mouseactions extends OpenCloseBrowser{

	@Test(dependsOnMethods={"slider", "accordion"}, groups={"Grouping1"}, retryAnalyzer = SeleniumSession1.RetryAnalyzer.class)
	public void draganddrop()
	{
		driver.get("https://jqueryui.com/droppable/");
		
		////*[@id="content"]/iframe
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		int framessize = driver.findElements(By.tagName("frame")).size();
		int iframessize = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No.of Frames present in this page: - " + framessize);
		System.out.println("No.of IFrames present in this page: - " + iframessize);
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		
		Assert.assertTrue(drag.isDisplayed());
		Assert.assertTrue(drop.isDisplayed());
		//Assert.assertFalse(drag.isDisplayed());
		Actions action1 = new Actions(driver);
		action1.dragAndDrop(drag, drop).perform();
	}
	
	@Test(groups={"Grouping2"})
	public void Resize()
	{
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement resize = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		Actions action1 = new Actions(driver);
		action1.clickAndHold(resize).moveByOffset(100, 100).release(resize).perform();
	}
	
	@Test(priority =0, enabled=true,  retryAnalyzer = SeleniumSession1.RetryAnalyzer.class)
	public void slider()
	{
		driver.get("https://jqueryui.com/slider/#custom-handle");
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.xpath("//*[@id='custom-handle']"));
		//Assert.assertFalse(slider.isDisplayed());
		Actions action1 = new Actions(driver);
		action1.clickAndHold(slider).moveByOffset(50, 0).release(slider).perform();
	}
	@Test(priority = 1, enabled=true, groups={"Grouping3"})
	public void accordion() throws InterruptedException
	{
		driver.get("https://jqueryui.com/accordion/#collapsible");
		driver.switchTo().frame(0);
		WebElement accord1 = driver.findElement(By.xpath("//*[@id='ui-id-1']/span"));
		int accordlist = driver.findElements(By.xpath("//*[starts-with(@id,'ui-id')]/span")).size();
		System.out.println("Total Accordions: "+ accordlist);
		
		//WebElement accordopen = driver.findElement(By.xpath("//*[starts-with(@id,'ui-id')]/span[@class='ui-accordion-header-icon ui-icon ui-icon-triangle-1-s']"));
		
		List<WebElement> accordclosed = driver.findElements(By.xpath("//*[starts-with(@id,'ui-id')]/span[@class='ui-accordion-header-icon ui-icon ui-icon-triangle-1-e']"));
		for(WebElement e: accordclosed)
		{
			e.click();
			Thread.sleep(500);
		}
		
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		////*[@id="content"]/div[1]/ul/li[3]/a
		WebElement nav1 = driver.findElement(By.xpath("//*[@id='content']/div[1]/ul/li[3]/a"));
		nav1.click();
		driver.switchTo().frame(0);
		
		accord1 = driver.findElement(By.xpath("//*[@id='ui-id-1']/span"));
		accordlist = driver.findElements(By.xpath("//*[starts-with(@id,'ui-id')]/span")).size();
		System.out.println("Total Accordions: "+ accordlist);
		accordclosed = driver.findElements(By.xpath("//*[starts-with(@id,'ui-id')]/span[@class='ui-accordion-header-icon ui-icon ui-icon-circle-arrow-e']"));

		for(WebElement e: accordclosed)
		{
			e.click();
			Thread.sleep(500);
		}
		//Actions action1 = new Actions(driver);
		//action1.click(accord1).perform();
	}
}

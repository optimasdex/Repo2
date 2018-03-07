package SeleniumSession1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 extends OpenCloseBrowser
{
	/*
	 * SoftAssert ast = new SoftAssert();
	 * 
	 * @Test
	 * 
	 * @Parameters({ "sSearchitems" }) public void parametertest(String
	 * sSearchitems){ System.out.println("Parameter Test");
	 * driver.get("http://www.google.com");
	 * System.out.println("Title of the page is - " + driver.getTitle());
	 * 
	 * /* String title = driver.getTitle();
	 * 
	 * ast.assertEquals(title, "Google123"); ast.assertAll();
	 * 
	 * 
	 * WebElement searchbox = driver.findElement(By.name("q")); try {
	 * driver.findElement(By.xpath("//div[@class='gstl_0 sbdd_a']"));
	 * System.out.println("Search empty overlay available"); } catch
	 * (NoSuchElementException e) {
	 * System.out.println("Search empty overlay NOT available"); }
	 * searchbox.sendKeys(sSearchitems);
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * try { // driver.findElement(By.xpath("//div[@class='gstl_0 sbdd_a' AND
	 * // @dir='ltr']")); List<WebElement> searchlist =
	 * driver.findElements(By.xpath("//div[@class='sbqs_c']"));
	 * System.out.println("Search overlay available");
	 * System.out.println("Count: " + searchlist.size()); for (WebElement we :
	 * searchlist) { System.out.println(we.getText()); } } catch
	 * (NoSuchElementException e) {
	 * System.out.println("Search overlay NOT available"); }
	 * 
	 * }
	 */

	@DataProvider(name = "DSearchlist")
	public static Object[] DataSearchlist()
	{
		return new Object[]
		{ "Selenium", "Google" };
	}

	@Test(groups =
	{ "Grouping1" }, dataProvider = "DSearchlist")
	public void dataprovidertest(String sSearchitems)
	{

		System.out.println("Parameter Test");
		driver.get("http://www.google.com");
		System.out.println("Title of the page is - " + driver.getTitle());

		/*
		 * String title = driver.getTitle();
		 * 
		 * ast.assertEquals(title, "Google123"); ast.assertAll();
		 */

		WebElement searchbox = driver.findElement(By.name("q"));
		try
		{
			driver.findElement(By.xpath("//div[@class='gstl_0 sbdd_a']"));
			System.out.println("Search empty overlay available");
		} catch (NoSuchElementException e)
		{
			System.out.println("Search empty overlay NOT available");
		}
		searchbox.sendKeys(sSearchitems);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try
		{
			// driver.findElement(By.xpath("//div[@class='gstl_0 sbdd_a' AND
			// @dir='ltr']"));
			List<WebElement> searchlist = driver.findElements(By.xpath("//div[@class='sbqs_c']"));
			System.out.println("Search overlay available");
			System.out.println("Count: " + searchlist.size());
			for (WebElement we : searchlist)
			{
				System.out.println(we.getText());
			}
		} catch (NoSuchElementException e)
		{
			System.out.println("Search overlay NOT available");
		}

	}
}

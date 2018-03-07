package Pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class ClassTest1
{
	public static void main(String[] args) throws InterruptedException
	{
		//Setting the system property for Firefox driver with the location of Geckodriver
		String FFService = "C:\\Data\\2017\\Selenium Tests\\Geckodriver\\geckodriver.exe";
		String ChromeService = "C:\\Data\\2017\\Selenium Tests\\ChromeDriver\\chromedriver.exe";
		String IEService = "C:\\Data\\2017\\Selenium Tests\\InternetDriver\\IEDriverServer.exe";

		System.setProperty("webdriver.gecko.driver", FFService);
		System.setProperty("webdriver.chrome.driver", ChromeService);
		System.setProperty("webdriver.ie.driver", IEService);

//		WebDriver FFdriver = new FirefoxDriver();
		WebDriver chdriver = new ChromeDriver();
//		WebDriver IEdriver = new InternetExplorerDriver();

//		FFdriver.get("http://google.com");
//		IEdriver.get("http://google.com");


//		String title = FFdriver.getTitle();
//		System.out.println("Title = " + title);
//		System.out.println("Title Length = " + title.length());
//		System.out.println("Present URL = " + FFdriver.getCurrentUrl());
//		if(FFdriver.getCurrentUrl().contains("https://www.google.com/"))
//		{
//			System.out.println("URL is properly loaded !!!");
//		}else
//		{
//			System.out.println("URL is NOT properly loaded !?!");
//		}
//		System.out.println("Present URL Length = " + FFdriver.getCurrentUrl().length());
//		//System.out.println("Present URL = " + FFdriver.getPageSource());
//		System.out.println("Present Source Code Length = " + FFdriver.getPageSource().length());
		
//		chdriver.get("http://demoqa.com/frames-and-windows/");		
//		chdriver.findElement(By.xpath("//*[@id='tabs-1']/div/p/a")).click();
//		chdriver.close();

		
		// Navigate commands 
//		chdriver.get("http://demoqa.com");		
//		chdriver.findElement(By.xpath("//*[@id='menu-item-374']/a")).click();
//		chdriver.navigate().back();
//		chdriver.navigate().forward();
//		chdriver.navigate().to("http://demoqa.com");
//		chdriver.navigate().refresh();

		
		
		chdriver.get("http://www.google.com");
		WebElement searchelement = chdriver.findElement(By.xpath("//input[@id='lst-ib']")); 
		searchelement.clear();
		System.out.println("Is search element enabled = "+ searchelement.isEnabled());
		System.out.println("Is search element displayed = "+ searchelement.isDisplayed());
		searchelement.sendKeys("google"+Keys.ENTER);
		
//		searchelement.wait(5000);
		
		searchelement = chdriver.findElement(By.xpath("//input[@id='lst-ib']"));
		System.out.println("Is search element enabled = "+ searchelement.isEnabled());
		System.out.println("Is search element displayed = "+ searchelement.isDisplayed());
		System.out.println("Searched Entered text = " + searchelement.getAttribute("value"));
		
		WebElement Glink= chdriver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/h3/a"));
		
		System.out.println("Google link enabled = " + Glink.isEnabled());
		System.out.println("Searched text = " + Glink.getText());
		
		Point point = Glink.getLocation();
		System.out.println("X coordinate : " + point.x + " Y coordinate: " + point.y);
		
		searchelement.clear();
		
		
		Thread.sleep(1000);
//		FFdriver.quit();
		chdriver.quit();
//		IEdriver.quit();
	}
}

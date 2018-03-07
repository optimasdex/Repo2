package SeleniumSession1;

import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class OpenCloseBrowser {

	WebDriver driver;
	 public static final String Path_TestData = "C://Users//ks5//workspace//SeleniumPrj1//src//DataPackage//";
	 public static final String File_TestData = "DataSheet1.xlsx";
	 
	//getLogger(Log.class.getName());
	//static final Logger Log = LogManager.getLogger();
	//Logger Log = LogManager.getLogger(OpenCloseBrowser.class);
	//DOMConfigurator.configure("log4j.xml");

		/*
	 * @BeforeClass
	 * 
	 * @AfterClass
	 * 
	 * @BeforeMethod
	 * 
	 * @AfterMethod
	 */
	@Parameters({"Browsers"})
	@BeforeClass(alwaysRun=true)
	public void Open(String browser) {
		if (browser.equalsIgnoreCase("firefox"))
		{
			String FFService = "C:\\Users\\ks5\\workspace\\SeleniumPrj1\\Lib_files\\Geckodriver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FFService);
			driver = new FirefoxDriver();
			//Log.info("Simple information to rint");
		}else if (browser.equalsIgnoreCase("chrome"))
		{
			String ChromeService = "C:\\Users\\ks5\\workspace\\SeleniumPrj1\\Lib_files\\ChromeDriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromeService);
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("iexplorer"))
		{
			String IEService = "C:\\Users\\ks5\\workspace\\SeleniumPrj1\\Lib_files\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", IEService);
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			
	}

	@AfterClass(alwaysRun=true)
	public void close() {
		driver.quit();
	}

}

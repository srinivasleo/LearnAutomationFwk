package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BrowserFactory {

	static WebDriver driver;
	static DesiredCapabilities capabilities;
	
	public static WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
//			System.setProperty("webdriver.gecko.driver",DataProviderFactory.getconfig().getFirefoxPath());
//			capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability("marionette", true);
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getconfig().getChromePath());
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",DataProviderFactory.getconfig().getIEPath());
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		 
	}
	
	public static void closeBrowser(WebDriver idriver)
	{
		driver.quit();
	}
}

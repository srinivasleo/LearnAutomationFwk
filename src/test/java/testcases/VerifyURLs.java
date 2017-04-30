package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.TakeScreenshot;
import utility.VerifyLinks;

public class VerifyURLs {
	WebDriver driver;

@BeforeTest
public void setup()
{
		driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
}
@Test
public void verifylinks()
{
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Total urls in the website are :" + list.size());
		for(int i=0;i < list.size();i++)
		{
			WebElement ele = list.get(i);
			String url = ele.getAttribute("href");
			VerifyLinks.VerifyUrl(url);
			
		}
}
@AfterMethod
public void teardown(ITestResult rs)
{
	if(ITestResult.FAILURE==rs.getStatus())
	{
		System.out.println("Exception screeshot taken");
		TakeScreenshot.getScreenshot(driver, "Failure1");
	}
}
@AfterTest
public void close()
{
	driver.close();
}
}

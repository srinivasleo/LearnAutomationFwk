package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage {

WebDriver driver;
@BeforeMethod
public void setup()
{
	driver = BrowserFactory.getBrowser("firefox");
	driver.get(DataProviderFactory.getconfig().getAppUrl());
	
}
@Test
public void testHomePage()
{
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	
	String Title = home.getApplicationTitle();
	
	Assert.assertTrue(Title.contains("Flipkart"));
	System.out.println("The title of web page is :  "+Title);
	
	BrowserFactory.closeBrowser(driver);
}
@AfterMethod
public void tearDown()
{
	BrowserFactory.closeBrowser(driver);
}
	

}

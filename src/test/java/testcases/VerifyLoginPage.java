package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
import pages.HomePage;
import pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {

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
	
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.loginToApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
	BrowserFactory.closeBrowser(driver);
}
@AfterMethod
public void tearDown()
{
	BrowserFactory.closeBrowser(driver);
}
	

}

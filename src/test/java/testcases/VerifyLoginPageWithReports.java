package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ExcelDataProvider;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageWithReports {

WebDriver driver;
ExtentReports report;
ExtentTest logger;

@BeforeMethod
public void setup()
{
	report = new ExtentReports("./Reports/LogInPageReport.html", true);
	logger = report.startTest("Verify Test Login");
	driver = BrowserFactory.getBrowser("firefox");
	driver.get(DataProviderFactory.getconfig().getAppUrl());
	
}
@Test
public void testHomePage()
{
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	
	String Title = home.getApplicationTitle();
	
	Assert.assertTrue(Title.contains("Flipkart"));
	//System.out.println("The title of web page is :  "+Title);
	logger.log(LogStatus.PASS,"HOme page loaded and verified");
	home.ClickOnSigninLink();
	logger.log(LogStatus.INFO,"click on signout link");
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.loginToApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
	logger.log(LogStatus.INFO,"Login to application");
	login.VerifySignOutLink();
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver,"validation1")));
	logger.log(LogStatus.PASS,"Sign out lik is presnt");
	BrowserFactory.closeBrowser(driver);
}
@AfterMethod
public void tearDown(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		String path = Helper.captureScreenshot(driver,result.getName());
		logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
	}
	
	BrowserFactory.closeBrowser(driver);
	report.endTest(logger);
	report.flush();
}
	

}

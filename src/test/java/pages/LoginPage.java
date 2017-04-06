package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
public LoginPage(WebDriver ldriver)
{
	this.driver=ldriver;
}

@FindBy(xpath="//input[@class='_2zrpKA']") 
WebElement username;
@FindBy(xpath="//input[@type='password']") 
WebElement pwd;
@FindBy(css="._2AkmmA._1LctnI._7UHT_c")
WebElement submit;

By signout=By.xpath("");

public void loginToApplication(String user,String passwd)
{
	username.sendKeys(user);
	pwd.sendKeys(passwd);
	submit.click();
}
public void VerifySignOutLink()
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signout));
	String text = ele.getText();
	Assert.assertEquals(text, "SignOut","Sign out link not verified poreproly");
}
}

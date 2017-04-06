package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(xpath ="//a[(text()='Log In')]") WebElement login; 
	@FindBy(xpath ="a[(text()='Hi Srinivas!')] ") WebElement Menu;
	@FindBy(xpath ="//a[(text()='My Orders ')] ") WebElement myorders;
	@FindBy(xpath ="//a[(text()='Account')]") WebElement accnt;
	@FindBy(xpath ="//a[(text()='Logout')]") WebElement logout;
	
	
	
	
	public void ClickOnSigninLink()
	{
		login.click();
	}
	public void ClickOnHiMenu()
	{
		Menu.click();
	}
	public void ClickOnMyAccount()
	{
		accnt.click();
	}
	public void ClickOnMyOrder()
	{
		myorders.click();
	}
	public void ClickOnLogout()
	{
		logout.click();
	}
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
}

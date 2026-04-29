package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement entermail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement enterpwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	
	public void setmail(String mail)
	{
		entermail.sendKeys(mail);
	}
	
	public void setpassword(String passwrd)
	{
		enterpwd.sendKeys(passwrd);
	}
	
	public void click_login()
	{
		login.click();
	}
	
	

}

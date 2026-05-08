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
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement wrongvalues;
	
	
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
	
	public String validate_wrongcredentials_msg()
	{
		try
		{
		return(wrongvalues.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	

}

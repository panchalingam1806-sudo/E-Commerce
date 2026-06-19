package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage{
	
	public LogOutPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement acclogout;
	
	@FindBy(linkText="Login")
	WebElement ddlogin;
	
	public String verify_logout_page()
	{
		try {
		return(acclogout.getText());
		}
		catch(Exception e) 
		{
			return(e.getMessage());
		}
	}
	
	public String verify_dropdown_login()
	{
		try {
		return(ddlogin.getText());
	}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
/*	
	public String verify_dropdown_login()
	{
		try {
		return(ddlogin.getText());
	}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	*/
	
	
	
	
}

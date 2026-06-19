package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	

	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement title;
	
	@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
	WebElement logoutbtn;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	WebElement continuebtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement dropmenulogout;
	
	public boolean isTitleVisible()
	{
		try 
		{
			return title.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clicklogoutbtn()
	{
		waitForClickable(logoutbtn);
		logoutbtn.click();
	}
	
	public void click_continue_btn()
	{
		continuebtn.click();
	}
	
	public void dd_logout()
	{
		dropmenulogout.click();
	}

}

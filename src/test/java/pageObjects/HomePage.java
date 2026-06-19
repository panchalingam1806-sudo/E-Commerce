package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{
	    public HomePage(WebDriver driver) {
	       super(driver);   
	}
	
	
	

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement my_acc;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement reg_btn;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement log_in;
	
	@FindBy(xpath="//title[text()='Your Store']")
	WebElement homepage_title;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement searchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchbutton;
	
	@FindBy(xpath="//a[text()='iMac']")
	WebElement prodnname;
	
	
	
	
	public void clickMyAccount()
	{
		waitForClickable(my_acc);
		my_acc.click();
	}
	
	public void registerButton()
	{
		waitForClickable(reg_btn);
		reg_btn.click();
	}
	
	public void clickLogin()
	{
		waitForClickable(log_in);
		log_in.click();
	}
	
	public String verifyHomepage()
	{		
		try {
			return(driver.getTitle());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void searchField(String productname)
	{
		waitForClickable(searchbox);
		searchbox.sendKeys(productname);
	}
	
	public void searchIcon()
	{
		waitForClickable(searchbutton);
		searchbutton.click();
	}
	
	public String productName()
	{
	   return prodnname.getText();
	}
	
	
	

}

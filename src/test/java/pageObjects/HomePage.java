package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement my_acc;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement reg_btn;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement log_in;
	
	public void clk_my_acc()
	{
		my_acc.click();
	}
	
	public void register_btn()
	{
		reg_btn.click();
	}
	
	public void clicklogin()
	{
		log_in.click();
	}

}

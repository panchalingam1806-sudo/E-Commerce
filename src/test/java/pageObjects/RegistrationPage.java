  package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement tel_num;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfpswd;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement sub_btn;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cont_btn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void first_name(String fstname)
	{
		fname.sendKeys(fstname);
	}
	
	public void last_name(String lstname)
	{
		lname.sendKeys(lstname);
	}
	
	public void e_mail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void telephone(String phone)
	{
		tel_num.sendKeys(phone);
	}
	public void password(String pswd)
	{
		pwd.sendKeys(pswd);
	}
	
	public void confirm_password(String cnfmpswd)
	{
		cnfpswd.sendKeys(cnfmpswd);
	}
	
	public void subscribe()
	{
		sub_btn.click();
	}
	
	public void priv_policy()
	{
		privacy.click();
	}
	
	public void continue_btn()
	{
		cont_btn.click();
	}
	
	
	public String  gettextinformation()
	{
		try
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	

}

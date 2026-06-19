package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductComparision extends BasePage{
	
	public ProductComparision(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//td[@class='text-center']")
	List<WebElement> productcount;
	
	@FindBy(xpath="//strong[contains(text(),'iMac')]")
	WebElement productname;
	
	@FindBy(css="img.img-thumbnail")
	WebElement imgofproduct;
	
	@FindBy(xpath="//td[text()='$122.00']")
	WebElement priceofproduct;
	
	@FindBy(xpath="//td[contains(text(),'Product 14')]")
	WebElement modelofproduct;
	
	@FindBy(xpath="//td[contains(text(),'Apple')]")
	WebElement brandofproduct;
	
	@FindBy(xpath="//td[contains(text(),'Out Of Stock')]")
	WebElement avilabilityofproduct;
	
	@FindBy(xpath="//td[@class='description']")
	WebElement summaryofproduct;
	
	@FindBy(css="[value='Add to Cart']")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//a[text()='Remove']")
	WebElement removebtn;
	
	
	
	public int getProductCount()
	{
		 return productcount.size();
	}
	
	public String nameOfProduct()
	{
		return productname.getText();
	}
	
	public boolean visibleOfImg()
	{
		return imgofproduct.isDisplayed();
	}
	
	public String getPrice()
	{
		return priceofproduct.getText();
	}
	
	public String getModel()
	{
		return modelofproduct.getText();
	}
	
	public String getBrand()
	{
		return brandofproduct.getText();
	}
	
	public String getAvailability()
	{
		return avilabilityofproduct.getText();
	}
	
	public String getSummary()
	{
		return summaryofproduct.getText();
	}
	
	public boolean isAddToCartBtnDisplayed()
	{
		return addtocartbtn.isDisplayed();
	}
	
	public boolean isAddToCartBtnEnabled()
	{
		return addtocartbtn.isEnabled();
	}
	
	public boolean isRemoveBtnDisplayed()
	{
		return removebtn.isDisplayed();
	}
	
	public boolean isRemoveBtnEnabled()
	{
		return removebtn.isEnabled();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

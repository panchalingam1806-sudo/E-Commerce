package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage 
{
	public ProductDisplayPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//h1[text()='iMac']")
	WebElement txtimac;
	
	@FindBy(xpath="//a[text()='Apple']")
	WebElement txtapple;
	
	@FindBy(xpath="//li[text()='Product Code:Product 14']")
	WebElement code;
	
	@FindBy(xpath="//li[text()='Availability:Out Of Stock']")
	WebElement stock;
	
	@FindBy(xpath="//h2[contains(text(),'$122.00')]")
	WebElement price;
	
	@FindBy(xpath="//li[contains(text(),'Ex Tax:$100.00')]")
	WebElement extax;
	
	@FindBy(xpath="//input[@name='quantity']")
	WebElement qty;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addcart;
	
	@FindBy(xpath="//input[starts-with(@id, 'input-quantity')]")
	WebElement increaseqnty;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//a[text()='iMac']")
	WebElement cartproduct;
	
//	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'shopping cart')]")
//	WebElement cartmsg;
	
	@FindBy(xpath="//div[contains(text(),'Success: You have added ')]")
	WebElement cartsuccess;
	
	
	public String txtImac()
	{
		return txtimac.getText();
	}
	
	public  String txtApple()
	{
		return txtapple.getText();
	}
	
	public String productCode()
	{
		return code.getText();
	}
	
	public String stockAvailability()
	{
		return stock.getText();
	}
	
	public String  priceOfProduct()
	{
		return price.getText();
	}
	
	public String exTaxOfIMac()
	{
		return extax.getText();
	}
	
	public int quantity()
	{
		return Integer.parseInt(qty.getAttribute("value"));
	}
	
	public void incQuantity()
	{
		increaseqnty.clear();
		increaseqnty.sendKeys("3");
	}
	
	public void addToCartBtn()
	{
		waitForClickable(addcart);
		addcart.click();
	}
	
	public String addCartProduct()
	{
		return cartproduct.getText();
	}
	
//	public String cartMsg()
//	{
//		return cartmsg.getText();
//	}
	
	public String cartSuccess()
	{
		return cartsuccess.getText().replace("×", "").trim();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

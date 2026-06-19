package pageObjects;

import java.util.List;

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
	
	@FindBy(xpath="//ul[@class='thumbnails']//li//a//img")
	List<WebElement> images;
	
	@FindBy(xpath="//button[@title='Previous (Left arrow key)']")
	WebElement previousbtn;
	
	@FindBy(xpath="//button[@title='Next (Right arrow key)']")
	WebElement nextbtn;
	
	@FindBy(xpath="//div[@class='mfp-counter']")
	WebElement countImage;
	
	@FindBy(xpath="//button[@title='Close (Esc)']")
	WebElement clickclose;
	
	
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
	
	public void clickThumbnailImage(int index)
	{
		 images.get(index).click();
	}
	
	public boolean validatePreviousBtn()
	{
		return previousbtn.isDisplayed() && previousbtn.isEnabled();
	}
	
	public boolean validateNextBtn()
	{
		return nextbtn.isDisplayed() && nextbtn.isEnabled();
	}
	
	public String validateImgView()
	{
		return countImage.getText();
	}
	
	public void clickPreviousBtn()
	{
		previousbtn.click();
	}
	
	public void clickNextBtn()
	{
		nextbtn.click();
	}
	
	public void clickCloseBtn()
	{
		clickclose.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

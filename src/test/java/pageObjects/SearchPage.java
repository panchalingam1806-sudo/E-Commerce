package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	
	@FindBy(xpath="//input[@id='input-search']")
	WebElement search_criteria;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@id='button-search']")
	WebElement searchbtn;
	
	@FindBy(xpath="//select[@name='category_id']")
	WebElement catedropdown;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement noproduct;
	
	@FindBy(xpath="//input[@name='sub_category']")
	WebElement subcategory;
	
	public void searchCriteriaBox(String searchcriteriatextbox)
	{
		search_criteria.sendKeys(searchcriteriatextbox);
	}
	
	public void descriptionCheckbox()
	{
		waitForClickable(checkbox);
		checkbox.click();
	}
	
	public void searchBtn()
	{
		waitForClickable(searchbtn);
		searchbtn.click();
	}
	
//	public void categoryDropdown()
//	{
//		waitForClickable(catedropdown);
//		catedropdown.click();
//	}
	
	@FindBy(xpath="//img[@title='iMac']")
	WebElement prodimg;
	
	@FindBy(css="div[class='col-sm-4'] button:nth-child(2)")
	WebElement hoveroncompare;
	
	@FindBy(xpath="")
	WebElement tooltipmsg;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement productnametext;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;
	
	@FindBy(xpath="//a[contains(text(), 'product comparison')]")
	WebElement prodcomparelink;
	
	@FindBy(xpath="//h1[normalize-space()='Product Comparison']")
	WebElement comparepage;
	
	@FindBy(css="#list-view")
	WebElement listview;
	
	@FindBy(css="button:nth-child(3)")
	WebElement listviewcompareproduct;
	
	@FindBy(css="#grid-view")
	WebElement gridview;
	
	public void selectCorrectCategoryDropdown(String categoryvalidvalue)
	{
		waitForClickable(catedropdown);
		Select allcategory = new Select(catedropdown);
		allcategory.selectByVisibleText(categoryvalidvalue);
	}
	
	public void selectWrongCategoryDropdown(String categoryinvalidvalue)
	{
		waitForClickable(catedropdown);
		Select allcategory = new Select(catedropdown);
		allcategory.selectByVisibleText(categoryinvalidvalue);
	}
	
	public void selectParentCategory(String parentCategory)
	{
		Select allcategory = new Select(catedropdown);
		allcategory.selectByVisibleText(parentCategory);
	}
	
	public String verifyNotShowingProduct()
	{
		try 
		{
			return (noproduct.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void subCategoryBox()
	{
		waitForClickable(subcategory);
		subcategory.click();
	}
	
	public void searchImg()
	{
		waitForClickable(prodimg);
		prodimg.click();
	}
	
	public void hoverOnCompareProduct()
	{
		waitForVisibility(hoveroncompare);
		act.moveToElement(hoveroncompare).build().perform();
	}
	
	public String toolTipmsg()
	{
		return hoveroncompare.getAttribute("data-original-title");
	}
	
	public void clickCompareToProduct()
	{
		waitForClickable(hoveroncompare);
		hoveroncompare.click();
	}
	
	public String productNameText()
	{
		return productnametext.getAttribute("value");
	}
	
	public String successMessage()
	{
		return successmsg.getText();
	}
	
	public void productComparisionLink()
	{
		waitForClickable(prodcomparelink);
		prodcomparelink.click();
	}
	
	public String productCompare()
	{
		return comparepage.getText();
	}
	
	public void listTypeView()
	{
		waitForClickable(listview);
		listview.click();
	}
	
	public void hoverListViewCompare()
	{
		waitForVisibility(listviewcompareproduct);
		act.moveToElement(listviewcompareproduct).perform();
	}
	
	public String listviewtoolTipmsg()
	{
		return listviewcompareproduct.getAttribute("data-original-title");
	}
	
	public void listViewCompareClick()
	{
		waitForClickable(listviewcompareproduct);
		listviewcompareproduct.click();
	}
	
	public void gridView()
	{
		waitForClickable(gridview);
		gridview.click();
	}
	
	
	
	
	
	
	
	

}

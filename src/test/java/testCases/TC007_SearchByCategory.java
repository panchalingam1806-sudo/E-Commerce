package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC007_SearchByCategory extends BaseClass{
	
	@Test(dataProvider="testData",dataProviderClass=DataProviders.class)
	public void valid_and_invalid_Category(String categoryvalidvalue)
	{
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		
		logger.info("****Clicked the Search Icon****");
		hp.searchIcon();
		
		logger.info("Enter Productname into Searchcrieria box");
		sp.searchCriteriaBox(p.getProperty("searchcriteriatextbox7"));

		logger.info("Select valid dropdown value");
		sp.selectCorrectCategoryDropdown(categoryvalidvalue);
		
		logger.info("Clicked search button in Search Page");
		sp.searchBtn();
		
		String prdname = hp.productName();
		
		logger.info("****Verified Product is Displayed****");
		Assert.assertEquals(prdname,"iMac","product not displayed");
		
		logger.info("Select invalid dropdown value");
		sp.selectWrongCategoryDropdown(p.getProperty("categoryinvalidvalue"));
		
		logger.info("Clicked search button");
		sp.searchBtn();
		
		String emptylist = sp.verifyNotShowingProduct();
		
		logger.info("****Verified Product is Not Displayed****");
		Assert.assertTrue(emptylist.contains("There is no product that matches the search criteria."),"Products are Displaying");
		
		logger.info("####Testcase Successfully Executed####");
		
		
		
		
		
		
	}
	
	
	
	

}

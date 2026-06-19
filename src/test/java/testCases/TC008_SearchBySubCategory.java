package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC008_SearchBySubCategory extends BaseClass {
	
	@Test
	public void sub_category_search()
	{
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		
		logger.info("****Clicked the Search Icon****");
		hp.searchIcon();
		
		logger.info("Enter productname into searchcriteria box");
		sp.searchCriteriaBox(p.getProperty("searchcriteriatextbox7"));
		
		logger.info("select parent category of the product");
		sp.selectParentCategory(p.getProperty("parentCategory"));
		
		logger.info("Clicked search button in Search Page");
		sp.searchBtn();
		
		
		String emptylist = sp.verifyNotShowingProduct();
		logger.info("Verify Products are not Displaying");
		Assert.assertTrue(emptylist.contains("There is no product that matches the search criteria."),"Products are Displaying");
		
		logger.info("Clicked Subcategory CheckBox");
		sp.subCategoryBox();
		
		logger.info("Clicked search button in Search Page");
		sp.searchBtn();
		
		String prdname = hp.productName();
		logger.info("****Verified Product is Displayed****");
		Assert.assertEquals(prdname,"iMac","product not displayed");
		
		logger.info("####Testcase Successfully Executed####");
		
		
		
	}
	
	
	
	
	
	
	
	

}

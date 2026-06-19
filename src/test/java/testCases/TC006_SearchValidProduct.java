package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC006_SearchValidProduct extends BaseClass{
	
	@Test(priority=1,groups={"funtional"})
	public void valid_product_search()
	{
		HomePage hp = new HomePage(getDriver());

		logger.info("####Tescase Started####");
		
		logger.info("****Enter the Product name in search box****");
		hp.searchField(p.getProperty("productname"));
		
		logger.info("****Clicked the Search Icon****");
		hp.searchIcon();
		
		String prdname = hp.productName();
		
		logger.info("****Verified Product is Displayed****");
		Assert.assertEquals(prdname,"iMac","product not displayed");
		
		logger.info("####Valid Product Search Testcase Executed Successfully####");
	}
	
	
	@Test(priority=2,groups= {"regression"})
	public void emptySearch()
	{
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		
		logger.info("****Clicked the Search Icon****");
		hp.searchIcon();
		
		logger.info("****Enter Text in search criteria box****");
		sp.searchCriteriaBox(p.getProperty("searchcriteriatextbox6"));
		
		logger.info("****Click the Chechkbox****");
		sp.descriptionCheckbox();
		
		logger.info("****Click the searchbutton in Search page****");
		sp.searchBtn();
		
		String prdname = hp.productName();
		
		logger.info("****Verified Product is Displayed****");
		Assert.assertEquals(prdname,"iMac","product not displayed");
		
		logger.info("####Empty Search Testcase Executed Successfully####");
		
		
	}

	
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC009_ComparisionProductDisplayPage extends BaseClass{
	
	
	@Test(priority=1)
	public void compareToProduct()
	{
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		
		logger.info("****Enter the Product name in search box****");
		hp.searchField(p.getProperty("productname"));
		
		logger.info("****Clicked the Search Icon****");
		hp.searchIcon();
		
		logger.info("****Clicked search display image****");
		sp.searchImg();
		
		logger.info("****Validate the Tooltip Text****");
		String actualTooltipmsg = sp.toolTipmsg();
		Assert.assertEquals(actualTooltipmsg, "Compare this Product", "Tooltip Text not Visible");
		
		logger.info("****Clicked Compare To Product****");
		sp.clickCompareToProduct();
		
		logger.info("****Validated the Success Text Message****");
		String actualTxtmsg = sp.successMessage();
		String expectedTxtMsg = ("Success: You have added " + sp.productNameText() + " to your product comparison!");
		
		Assert.assertTrue(actualTxtmsg.trim().contains(expectedTxtMsg), "Validate Text Message is Wrong");
		
		logger.info("****Clicked Product Comparision Link****");
		sp.productComparisionLink();
		
		logger.info("****Verified Product Comparision Page****");
		String actualComparePage = sp.productCompare();
		Assert.assertEquals(actualComparePage, "Product Comparison", "This Not a Product ComparisionPage");
		
		logger.info("****TestCase Executed Successfully****");
		
	}
	
	
	/*
	@Test(priority=2)
	public void listViewCompare()
	{
		
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		
		logger.info("****Enter the Product name in search box****");
		hp.searchField(p.getProperty("productname"));
		
		logger.info("****Clicked the Search Icon****");
		hp.searchIcon();
		
//		logger.info("****Clicked List View****");
//		sp.listTypeView();
		
		logger.info("****Clicked Grid View****");
		sp.gridView();
		
		logger.info("****Hover the compare product****");
		sp.hoverListViewCompare();
		
		logger.info("****Validate the Tooltip Text****");
		String actualTooltipmsg = sp.listviewtoolTipmsg();
		Assert.assertEquals(actualTooltipmsg, "Compare this Product", "Tooltip Text not Visible");
		
		logger.info("****Clicked the Compare product in list view****");
		sp.listViewCompareClick();
		
		logger.info("****Validated the Success Text Message****");
		String actualTxtmsg = sp.successMessage();
		String expectedTxtMsg = ("Success: You have added " + sp.productNameText() + " to your product comparison!");
		
		Assert.assertTrue(actualTxtmsg.trim().contains(expectedTxtMsg), "Validate Text Message is Wrong");
		
		logger.info("****Clicked Product Comparision Link****");
		sp.productComparisionLink();
		
		logger.info("****Verified Product Comparision Page****");
		String actualComparePage = sp.productCompare();
		Assert.assertEquals(actualComparePage, "Product Comparison", "This Not a Product ComparisionPage");
		
		logger.info("****TestCase Executed Successfully****");
		
	}*/

}

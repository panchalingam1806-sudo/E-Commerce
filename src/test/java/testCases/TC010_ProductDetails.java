package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparision;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC010_ProductDetails extends BaseClass{
	
	@Test
	public void productDetailsValidation()
	{
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		ProductComparision pc = new ProductComparision(getDriver());
		
		logger.info("####TestCase Started####");
		
		hp.searchField(p.getProperty("productname"));
		logger.info("****Enter the Product name in search box****");
		
		
		hp.searchIcon();
		logger.info("****Clicked the Search Icon****");
		
		
		sp.searchImg();
		logger.info("****Clicked search display image****");
		
		
		sp.clickCompareToProduct();
		logger.info("****Clicked Compare To Product****");
		
		
		sp.productComparisionLink();
		logger.info("****Clicked Product Comparision Link****");
		
		Assert.assertEquals(pc.getProductCount(), 1, "More than one Product is Displayed");
		logger.info("****Validated only one product is Displayed****");
		
		Assert.assertEquals(pc.nameOfProduct(), "iMac", "Name of the Product is Different");
		logger.info("****Validated the Name of the Product****");
		
		Assert.assertTrue(pc.visibleOfImg());
		logger.info("****Validated the Image of the Product****");
		
		Assert.assertEquals(pc.getPrice(), "$122.00", "Price of the Product is Different");
		logger.info("****Validated the Price of the Product****");
		
		Assert.assertEquals(pc.getModel(), "Product 14", "Model Of the Product is Different");
		logger.info("****Validated the Model of the Product****");
		
		Assert.assertEquals(pc.getBrand(), "Apple", "Brand Of the Product is Different");
		logger.info("****Validated the Brand of the Product****");
		
		Assert.assertEquals(pc.getAvailability(), "Out Of Stock");
		logger.info("****Validated the Availability of the Product****");
		
		Assert.assertTrue(pc.getSummary().contains("iMac"));
		logger.info("****Validated the Summary of the Product****");
		
		Assert.assertTrue(pc.isAddToCartBtnDisplayed());
		Assert.assertTrue(pc.isAddToCartBtnEnabled());
		logger.info("****Validated the AddToCart Button of the Product****");
		
		Assert.assertTrue(pc.isRemoveBtnDisplayed());
		Assert.assertTrue(pc.isRemoveBtnEnabled());
		logger.info("****Validated the Remove Button of the Product****");
		
		logger.info("####TestCase Executed Successfully####");
		
		
		
		
	}

}

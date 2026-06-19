package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC011_ProductPriceDetails extends BaseClass {
	
	@Test
	public void productPricedetails() 
	{
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		ProductDisplayPage pdp = new ProductDisplayPage(getDriver());
		SoftAssert sa = new SoftAssert();
		
		logger.info("####TestCase Started####");
		
		hp.searchField(p.getProperty("productname"));
		logger.info("****Enter the Productname in the input field****");
		
		hp.searchIcon();
		logger.info("****Click the SearchIcon Button****");
		
		sp.searchImg();
		logger.info("****Click the Search Image on the Showing Display****");
		
		sa.assertEquals(pdp.txtImac(), "iMac",  "Name Of the Product is Not Same");
		sa.assertEquals(pdp.txtApple(), "Apple", "Brand Of the Product is Not Same");
		sa.assertEquals(pdp.productCode(), "Product Code:Product 14", "Product Code is Not Same");
		sa.assertEquals(pdp.stockAvailability(), "Availability:Out Of Stock", "Product is Available");
		sa.assertEquals(pdp.priceOfProduct(), "$122.00", "Price Of the product is Different");
		sa.assertEquals(pdp.exTaxOfIMac(), "Ex Tax:$100.00", "Ex-Tax of the Product is Different ");
		sa.assertEquals(pdp.quantity(), 1, "Quantity is more than 1");	
		logger.info("****Validated the Product Details****");
		
		pdp.incQuantity();
		logger.info("****Increasing the Quantity field more than one****");
		
		sa.assertEquals(pdp.quantity(), 3, "Quantity is less than or equal to 1");
		logger.info("****Validated the quantity field increase the Quantity****");
		
		pdp.addToCartBtn();
		logger.info("****Click the Add to Cart Button****");

		String actualMsg = pdp.cartSuccess();
		
		String expectedmsg = ("Success: You have added " + pdp.addCartProduct() + " to your shopping cart!");
		sa.assertEquals(actualMsg, expectedmsg, "Validate msg is Wrong");
		logger.info("****Validated the add to cart Successful Message****");

		sa.assertAll();
		
		logger.info("####TestCase Successfully Executed####");
	}
}
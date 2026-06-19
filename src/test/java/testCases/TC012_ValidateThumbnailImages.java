package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC012_ValidateThumbnailImages extends BaseClass {

	
	@Test
	public void validate_thumbnail_image()
	{
		HomePage hp = new HomePage(getDriver());
		SearchPage sp = new SearchPage(getDriver());
		ProductDisplayPage pdp = new ProductDisplayPage(getDriver());
		
		
		logger.info("####TestCase validate_thumbnail_image Started####");
		
		hp.searchField(p.getProperty("productname"));
		logger.info("****Enter the Productname in the input field****");
		
		hp.searchIcon();
		logger.info("****Click the SearchIcon Button****");
		
		sp.searchImg();
		logger.info("****Click the Search Image on the Showing Display****");
		
		pdp.clickThumbnailImage(0);
		logger.info("****Click on the Main Bigger sized Thumbnail image****");
		
		Assert.assertTrue(pdp.validatePreviousBtn(), "Previous button should be visible and enabled");
		Assert.assertTrue(pdp.validateNextBtn(), "Next button should be visible and enabled");
		logger.info("****Validating the Previous and Next Buttons****");
		
		Assert.assertEquals(pdp.validateImgView(), "1 of 3", "3 Thumbails Products are Displaying");
		logger.info("****Validate the Products count****");
		System.out.println(pdp.validateImgView());
		
		
		pdp.clickPreviousBtn();
		logger.info("****Click the Previous Button in the Light Box View****");
		
		Assert.assertEquals(pdp.validateImgView(), "3 of 3", "Now it's Navigate to the 3rd Thumbnail Image");
		logger.info("****Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickNextBtn();
		logger.info("****Click the Next Button in the Light Box View****");
		
		Assert.assertEquals(pdp.validateImgView(), "1 of 3", "Again it's Navigate to 1st Thumbnail Product");
		logger.info("****Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickCloseBtn();
		logger.info("****Click the Close Button in the Light Box View****");
		
		pdp.clickThumbnailImage(1);
		logger.info("****Click on the First Small Thumbnail Image****");
		
		Assert.assertEquals(pdp.validateImgView(), "2 of 3", "3 Thumbails Products are Displaying");
		logger.info("****Again Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickPreviousBtn();
		logger.info("****Click the Previous Button in the Light Box View****");
		
		Assert.assertEquals(pdp.validateImgView(), "1 of 3", "Now it's Navigate to the 3rd Thumbnail Image");
		logger.info("****Again Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickNextBtn();
		logger.info("****Click the Next Button in the Light Box View****");
		
		Assert.assertEquals(pdp.validateImgView(), "2 of 3", "Again it's Navigate to 1st Thumbnail Product");
		logger.info("****Again Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickCloseBtn();
		logger.info("****Click the Close Button in the Light Box View****");
		
		pdp.clickThumbnailImage(2);
		logger.info("****Click on the Second Small Thumbnail Image****");
		
		Assert.assertEquals(pdp.validateImgView(), "3 of 3", "3 Thumbails Products are Displaying");
		logger.info("****Again Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickPreviousBtn();
		logger.info("****Click the Previous Button in the Light Box View****");
		
		Assert.assertEquals(pdp.validateImgView(), "2 of 3", "Now it's Navigate to the 3rd Thumbnail Image");
		logger.info("****Again Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickNextBtn();
		logger.info("****Click the Next Button in the Light Box View****");
		
		Assert.assertEquals(pdp.validateImgView(), "3 of 3", "Again it's Navigate to 1st Thumbnail Product");
		logger.info("****Again Validate the Products Navigation Based On Products count****");
		System.out.println(pdp.validateImgView());
		
		pdp.clickCloseBtn();
		logger.info("****Click the Close Button in the Light Box View****");

		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}

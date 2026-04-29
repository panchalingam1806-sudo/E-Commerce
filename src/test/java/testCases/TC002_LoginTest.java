package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Regression","Master"})
	public void logincredentials()
	{
		logger.info("****TC002 Startded****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clk_my_acc();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.click_login();
		
		MyAccountPage ap = new MyAccountPage(driver);
		logger.info("****Validating the Title****");
		boolean titlepage = ap.isTitleVisible();
//		Assert.assertEquals(titlepage, true,"Test failed");
		Assert.assertTrue(titlepage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****TC002 Ended****");
	}
	
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"smoke","functional_login"})
	public void logincredentials()
	{
		logger.info("****TC002 Startded****");
		
		try
		{
		HomePage hp = new HomePage(getDriver());
		hp.clk_my_acc();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(getDriver());
		lp.setmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.click_login();
		
		MyAccountPage ap = new MyAccountPage(getDriver());
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

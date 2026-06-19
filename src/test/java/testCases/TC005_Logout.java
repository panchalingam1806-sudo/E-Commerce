package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC005_Logout extends BaseClass{
	
	@Test
	public void verify_logout()
	{
		HomePage hp = new HomePage(getDriver());
		MyAccountPage ap = new MyAccountPage(getDriver());
		LoginPage lp = new LoginPage(getDriver());
		LogOutPage lop = new LogOutPage(getDriver());
		
		logger.info("#### Before Starting Testcase we Have to Login ####");
		hp.clickMyAccount();
		hp.clickLogin();
		
		lp.setMail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.click_login();
		logger.info("#### Login Successfull ####");
		
		
		logger.info("#### Actual Testcase Starts Here! ####");
		
		hp.clickMyAccount();
		logger.info("#### Clicked my account dropdown menu ####");
		
		ap.dd_logout();
		logger.info("#### clicked logout option in dropdown menu ####");
		
		String logoutpage = lop.verify_logout_page();
		
		logger.info("#### Assertion for logout page and login option under myaccount dropdown ####");
		
		Assert.assertEquals(logoutpage,"Account Logout","logout page title mismatch");
		
		hp.clickMyAccount();
		
		String ddloginverify = lop.verify_dropdown_login();
		
		Assert.assertEquals(ddloginverify,"Login","Login option not found under My Account dropdown");

		ap.click_continue_btn();
		logger.info("****Clicked continue button****");
		
		String home_page = hp.verifyHomepage();
		
		logger.info("****Verifying HomePage****");
		Assert.assertEquals(home_page,"Your Store","Homepage not verified");
		
		logger.info("*****Test Case Finished*****");
		
	}
}

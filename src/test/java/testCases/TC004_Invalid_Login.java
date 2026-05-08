package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC004_Invalid_Login extends BaseClass {
	
	@Test(groups= {"regression","functional_login"})
	public void verify_invalid_login()
	{
		logger.info("****TC_04 STARTED****");
		try {
		HomePage hp = new HomePage(getDriver());
		logger.info("clicked my account link");
		hp.clk_my_acc();
		logger.info("clicked login button in homepage ");
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(getDriver());
		
		logger.info("Entered invalid email");
		lp.setmail(p.getProperty("invalidemail"));
		
		logger.info("Entered invalid password");
		lp.setpassword(p.getProperty("invalidpassword"));
		
		logger.info("clicked login button in loginpage");
		lp.click_login();
		
		String warningmsg = lp.validate_wrongcredentials_msg();
		
//		Assert.assertEquals(warningmsg, "Warning: No match for E-Mail Address and/or Password.");
		
		if(warningmsg.equals("Warning: No match for E-Mail Address and/or Password."))
		{
			Assert.assertTrue(true);
		}else 
		{
			logger.error("TC04 FAILED");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****TC04 Successfully Executed****");
		
	}
	}


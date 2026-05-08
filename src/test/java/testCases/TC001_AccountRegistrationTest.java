package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"smoke","functional_registration"})
	public void verify_account_registration()
	{
		try {
		logger.info("*****Test Case Started*****");
		
		HomePage hp = new HomePage(getDriver());
		
		hp.clk_my_acc();
		logger.info("Clicked on my account link");
		
		hp.register_btn();
		logger.info("Cllicked on registered link");
		
		RegistrationPage regpage = new RegistrationPage(getDriver());
		
		logger.info("Providing Customer Details");
		
		regpage.first_name(randomString());
		regpage.last_name(randomString());
		regpage.e_mail(randomString()+"123@gmail.com");
		regpage.telephone(randomnumeric());
		
		String pass = randomalphanumeric();
		regpage.password(pass);  
		regpage.confirm_password(pass);
		
		regpage.subscribe();
		regpage.priv_policy();
		regpage.continue_btn();
		
		logger.info("Validating Expected Message");
		String confmsg = regpage.gettextinformation();
		
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			System.out.println("Actual message: [" + confmsg + "]");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
//		Assert.assertEquals(confmsg,"Your Account Has Been Creat!");     
	}
		
	catch(Exception e)
	{
		e.printStackTrace();
		Assert.fail("Account registration failed" + e.getMessage());
	}
		logger.info("*****Test Case Finished*****");
	}

}

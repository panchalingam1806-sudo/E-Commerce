package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

	
public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class,groups= {"Sanity","Regresssion","Master","DataDriven"})
	public void verify_ddt_login(String email, String pwd,  String exp)
	{
		
	logger.info("**** TC003 Started ****");
	
	try 
	{
	HomePage hp = new HomePage(driver);
	hp.clk_my_acc();
	hp.clicklogin();
	
	LoginPage lp = new LoginPage(driver);
	lp.setmail(email);
	lp.setpassword(pwd);
	lp.click_login();
	
	MyAccountPage ap = new MyAccountPage(driver);
	boolean titlepage = ap.isTitleVisible();
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(titlepage==true) 
		{
			ap.clicklogoutbtn();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);	
		}
	}
	
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(titlepage==true)
		{
			ap.clicklogoutbtn();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("**** TC003 Ended ****");
	}
}






/*
The process of passing values from an Excel file to the email, password, and expected result (exp) variables involves a series of steps using a Data Provider and Excel Utility class. Here is how it works:

Excel Utility Setup (30:30-34:55): An ExcelUtility class contains reusable methods to interact with the Excel file (e.g., getRowCount, getCellData). A constructor in this class takes the file path, allowing the automation to read specific cells based on row and column indexes.

Data Provider Logic (43:07-50:28): A separate DataProviders.java class acts as the bridge.

It retrieves the total number of rows and columns from the Excel sheet.
It creates a two-dimensional array (String[][]) with the same size as the data in the Excel file.
A for loop (47:55-49:50) iterates through the sheet, reading the data from each cell and storing it into the two-dimensional array.
The method then returns this array to the test case.
Data Injection into Test Case (1:00:49-1:06:20):

In the test class, the @Test annotation uses the dataProvider parameter to point to the method defined in the DataProviders class.
The test method is defined with three parameters—String email, String password, and String exp—which correspond to the columns in the Excel sheet.
TestNG automatically maps the values from the returned two-dimensional array into these variables, allowing the test to execute using that specific row of data.
 */

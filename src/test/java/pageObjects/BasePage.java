package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		 if (driver == null) {
	        throw new RuntimeException("Driver is null while initializing Page Object");
		 }
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}



/*
public class BasePage {

    public WebDriver getDriver() {
        return BaseClass.getDriver(); // ThreadLocal driver
    }

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
}
*/

package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected Actions act;
	protected int timeout = 10;
	
	public BasePage(WebDriver driver)
	{
		 if (driver == null) {
	        throw new RuntimeException("Driver is null while initializing Page Object");
		 }
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}



	public void waitForVisibility(WebElement visiblewait)
	{
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		mywait.until(ExpectedConditions.visibilityOf(visiblewait));
	}
	
	public void waitForClickable(WebElement clickwait)
	{
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		mywait.until(ExpectedConditions.elementToBeClickable(clickwait));
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

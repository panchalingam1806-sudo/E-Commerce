package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	 protected Logger logger = LogManager.getLogger(this.getClass());
	
public static WebDriver driver;

public Properties p;


private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

public static WebDriver getDriver() {
    return  tdriver.get();
}
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		String path = System.getProperty("user.dir") +"/src/test/resources/config.properties";
		FileReader file = new FileReader(path);
		p=new Properties();
		p.load(file);

		WebDriver driver = null;  
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver();
		break;
		case "edge" : driver=new EdgeDriver();
		break;
		case "firefox" : driver= new FirefoxDriver();
		break;
		default : System.out.println("****invalid browser name****");
		throw new RuntimeException("Message");
		 //this return value is exit from the automationScript directly
		}
		}
		
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
		    switch(br.toLowerCase())
		    {
		        case "chrome":
		            ChromeOptions chromeOptions = new ChromeOptions();
		            driver = new RemoteWebDriver(
		                    new URL("http://localhost:4444"),
		                    chromeOptions);
		            break;

		        case "edge":
		            EdgeOptions edgeOptions = new EdgeOptions();
		            driver = new RemoteWebDriver(
		                    new URL("http://localhost:4444"),
		                    edgeOptions);
		            break;

		        case "firefox":
		            FirefoxOptions firefoxOptions = new FirefoxOptions();
		            driver = new RemoteWebDriver(
		                    new URL("http://localhost:4444"),
		                    firefoxOptions);
		            break;

		        default:
		            System.out.println("No Matching Browser");
		            throw new RuntimeException("Invalid Browser");
		    }
		}
		
		 if(driver == null)
		    {
		        throw new RuntimeException("Driver not initialized properly");
		    }
		
		tdriver.set(driver);
		System.out.println("Driver initialized: " + getDriver());
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getDriver().get(p.getProperty("appurl1"));
		getDriver().manage().window().maximize();
	}
	
	
	
	@AfterMethod(alwaysRun=true,groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		if(getDriver() != null)
		{
			getDriver().quit();
			tdriver.remove();
			LogManager.shutdown();
		}
	}
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	
	public String randomnumeric()
	{
		String generatednumeric = RandomStringUtils.randomNumeric(9);
		return generatednumeric;
	}
	
	public String randomalphanumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(4);
		String generatednumeric = RandomStringUtils.randomNumeric(3);
		return (generatedstring+"#"+generatednumeric);
	}
	

//	public static String captureScreen(String tname) throws IOException
	public static String captureScreen(String tname) throws IOException
	{
		 WebDriver driver = getDriver();

		    if (driver == null) {
		        System.out.println("Cannot take screenshot - driver is null");
		        return null;
		    }
		    System.out.println("Driver in screenshot = " + getDriver());
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  //time stamp format 
		
		TakesScreenshot  ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		
		
		String targetfilepath = System.getProperty("user.dir")+"/screenshots/" + tname + "_" + timeStamp + ".png";
		File targetfile = new File(targetfilepath);
		
		targetfile.getParentFile().mkdirs();
		FileUtils.copyFile(sourcefile, targetfile);
		
		return targetfilepath;
	}
	
	
	/*
	public String captureScreen(String tname) throws IOException
	{
	    WebDriver driver = BaseClass.getDriver();

	    if (driver == null) {
	        System.out.println("Cannot take screenshot - driver is null");
	        return null;
	    }

	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File sourcefile = ts.getScreenshotAs(OutputType.FILE);

	    String targetfilepath = System.getProperty("user.dir")
	            + "/screenshots/"
	            + tname + "_" + timeStamp + ".png";

	    File targetfile = new File(targetfilepath);

	    // ✅ IMPORTANT: ensure folder exists
	    targetfile.getParentFile().mkdirs();

	    // ✅ FIX: use copyFile instead of renameTo
	    FileUtils.copyFile(sourcefile, targetfile);

	    return targetfilepath;
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

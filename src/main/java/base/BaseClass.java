package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;
import utils.ReportLogger;


public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
    public ExtentReports extent;
    public ExtentTest test;	
    String strTestName = this.getClass().getSimpleName();
    
	@BeforeSuite
	public void fun_loadConfig()
	{
		//String strTestName = this.getClass().getSimpleName();
		extent = ExtentManager.getInstance(strTestName);
		
		prop = new Properties();
		try {		
			FileInputStream fis = new FileInputStream("src/test/resources/globalVars.properties");
			prop.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void fun_setUp(Method method) {
	  
		test = extent.createTest(strTestName);
        
		String strBrowserType = prop.getProperty("browserType");
		
		if (strBrowserType.equalsIgnoreCase("CHROME"))
		{
			driver = new ChromeDriver();
		}
		else if (strBrowserType.equalsIgnoreCase("EDGE"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.err.println("Browser type is either not defined or not correctly mentioned. 'browserType : '"+strBrowserType);
			System.exit(1);	
		}

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("appUrl"));
        
        //Start report
        ReportLogger.fun_logForStartAndEndScreenshot(driver, test, Status.INFO, "Test Start ");
		
	  //use this to launch browser
  }
	
	@AfterMethod
	public void fun_tearDown()
	{
		
		 ReportLogger.fun_logForStartAndEndScreenshot(driver, test, Status.INFO, "Test Completed");
		 
	    // Always quit the browser
	    if (driver != null) {
	        driver.quit();
	    }
	}
	
	@AfterSuite
	public void fun_suitPostReq()
	{
		extent.flush();
	}
	
	
}

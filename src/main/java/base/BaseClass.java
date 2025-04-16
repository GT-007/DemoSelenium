package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	
	@BeforeSuite
	public void fun_loadConfig()
	{
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
	public void fun_setUp() {
	  
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
        
		
	  //use this to launch browser
  }
	
	@AfterMethod
	public void fun_tearDown()
	{
		driver.close();
	}
	
}

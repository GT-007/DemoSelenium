package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;
import utils.LoadTestData;
import utils.ReportLogger;


public class BaseClass {
	
	public WebDriver objDriver;
	public Properties objProp;
    public ExtentReports objExtentSummaryReport, objExtentIndiviualReport;
    public ExtentTest objExtentSummaryTest;
	public ExtentTest objExtentIndividualTest;
   
    public Map<String, String> MapTestData = new HashMap<>();
    
    String strTestName ;
    String strExecutionSummary =  "ExecutionSummary";
    
    
    @BeforeSuite
    public void fun_testPreReq()
    {
    	//strTestName = this.getClass().getSimpleName();
    	
		//Load data from properties file
		objProp = new Properties();
		try {		
			FileInputStream fis = new FileInputStream("src/test/resources/globalVars.properties");
			objProp.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


    }
	
	@BeforeMethod
	public void fun_LauchBrowser(Method method) {
		
    	//strTestName = this.getClass().getSimpleName();
    	
		//Load data from properties file
		objProp = new Properties();
		try {		
			FileInputStream fis = new FileInputStream("src/test/resources/globalVars.properties");
			objProp.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		strTestName = method.getDeclaringClass().getSimpleName();
		
		//Create report summary and individual test report object		
		objExtentSummaryReport = ExtentManager.fun_getSummaryReportInstance(strExecutionSummary,objProp.getProperty("browserType"));
		objExtentIndiviualReport = ExtentManager.fun_getIndividualReportInstance(strTestName);
		
		objExtentSummaryTest = objExtentSummaryReport.createTest(strTestName);
		objExtentIndividualTest = objExtentIndiviualReport.createTest(strTestName);

        //Start test case report for individual test report
        //ReportLogger.fun_logForStartAndEndScreenshot(objDriver, objExtentIndividualTest, Status.INFO, "Test Started ");
        
        //load test data
        try {
        	MapTestData = LoadTestData.fun_fetchTestData("src/test/resources/TestData.xlsx", 
        						"AutomationExercise", strTestName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//Fetch which browser to use for testing
		String strBrowserType = objProp.getProperty("browserType");
		
		if (strBrowserType.equalsIgnoreCase("CHROME"))
		{
			objDriver = new ChromeDriver();
		}
		else if (strBrowserType.equalsIgnoreCase("EDGE"))
		{
			objDriver = new EdgeDriver();
		}
		else
		{
			System.err.println("Browser type is either not defined or not correctly mentioned. 'browserType : '"+strBrowserType);
			System.exit(1);	
		}

		objDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		objDriver.manage().window().maximize();
		objDriver.get(objProp.getProperty("appUrl"));
        
  }
	
	@AfterMethod
	public void fun_tearDown(ITestResult result)
	{
		ReportLogger.fun_logForStartAndEndScreenshot(objDriver, objExtentIndividualTest, Status.INFO, "Test Completed");
		
        if (result.getStatus() == ITestResult.FAILURE)
        	ReportLogger.fun_logForTestCaseStatus(objExtentSummaryTest, Status.FAIL, strTestName);
        
        else if (result.getStatus() == ITestResult.SUCCESS)
        	ReportLogger.fun_logForTestCaseStatus(objExtentSummaryTest, Status.PASS, strTestName);
        
        else
        	ReportLogger.fun_logForTestCaseStatus(objExtentSummaryTest, Status.SKIP, strTestName);
        
	    objExtentSummaryReport.flush();
	    objExtentIndiviualReport.flush();
	    
	    // Always quit the browser
	    if (objDriver != null) {	    	
	    	objDriver.quit();    	
	    }

	}

	
	
	
}

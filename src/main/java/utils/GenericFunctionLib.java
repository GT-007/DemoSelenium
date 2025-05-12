package utils;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class GenericFunctionLib{
	
	WebDriver driver;
	ExtentTest test;
	public void fun_compareBolVariable(boolean a, boolean b)
	{
		if (a==b)
		{
			ReportLogger.fun_logStatusStepInReport(driver, test, Status.PASS,"Validated");
		}
		else
		{
			ReportLogger.fun_logStatusStepInReport(driver, test, Status.FAIL, "Not validated");
		}
	}

	public GenericFunctionLib(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}

}

package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;



public class ReportLogger {
	   
	public static void fun_logInfoStepInReport(WebDriver driver, ExtentTest test, int intStepNo,
			String message) {
		
		String strBase64ScreenSht = Screenshot.captureScreenshot(driver);

		test.log(Status.INFO, "Step - " + intStepNo + " : " + message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(strBase64ScreenSht).build());
	}

	public static void fun_logStatusStepInReport(WebDriver driver, ExtentTest test, Status status ,
			String message) {
		
		String strBase64ScreenSht = Screenshot.captureScreenshot(driver);

		test.log(status, message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(strBase64ScreenSht).build());
		
		if (status.equals(Status.FAIL))
		{
			Assert.fail();
		}

	}
	
	public static void fun_logForStartAndEndScreenshot(WebDriver driver, ExtentTest test, Status status,
			String message) {
		String strBase64ScreenSht = Screenshot.captureScreenshot(driver);

		test.log(status, message, MediaEntityBuilder.createScreenCaptureFromBase64String(strBase64ScreenSht).build());

	}
	
	public static void fun_logForTestCaseStatus(ExtentTest test, Status status, String message) {

		test.log(status, message);
	}

}

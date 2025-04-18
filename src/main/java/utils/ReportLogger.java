package utils;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ReportLogger {

	public static void fun_logWithStepNoAndScreenshot(WebDriver driver, ExtentTest test, Status status, int intStepNo,
			String message) {
		String strBase64ScreenSht = Screenshot.captureScreenshot(driver);

		test.log(status, "Step - " + intStepNo + " : " + message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(strBase64ScreenSht).build());

	}

	public static void fun_logForStartAndEndScreenshot(WebDriver driver, ExtentTest test, Status status,
			String message) {
		String strBase64ScreenSht = Screenshot.captureScreenshot(driver);

		test.log(status, message, MediaEntityBuilder.createScreenCaptureFromBase64String(strBase64ScreenSht).build());

	}

}

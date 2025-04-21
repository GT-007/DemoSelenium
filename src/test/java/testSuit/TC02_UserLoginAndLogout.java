package testSuit;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import utils.ReportLogger;

public class TC02_UserLoginAndLogout extends BaseClass{
  @Test
  public void f() {
	  
	  ReportLogger.fun_logStepInReport(objDriver, objExtentIndividualTest, Status.PASS, 1, "Registeration page displayed");
  }
}

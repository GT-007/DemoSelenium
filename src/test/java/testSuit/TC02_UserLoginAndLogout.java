package testSuit;

import org.testng.annotations.Test;
import base.BaseClass;
import pages.Home;
import pages.LoginSignUp;
import utils.GenericFunctionLib;
import utils.ReportLogger;

public class TC02_UserLoginAndLogout extends BaseClass{
	
	
	
  @Test
  public void test() {
	  System.out.println("Driver is: " + objDriver);
	  LoginSignUp login = new LoginSignUp(objDriver);
	  Home home = new Home(objDriver);
	  GenericFunctionLib genericFunction = new GenericFunctionLib(objDriver, objExtentIndividualTest);
	  String strTestStepDescription;
	  
	  //*******************************************************************************************************
	  //Step : 1
	  strTestStepDescription = "Login to the application with valid user.";
	  ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 1, strTestStepDescription);

	  login.fun_login(objProp.getProperty("strEmailId"), objProp.getProperty("strPassword"));
	  
	  //*******************************************************************************************************
	  //Step : 2
	  strTestStepDescription = "Validate that Home page is displayed with logout button.";
	  ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 2, strTestStepDescription);
	  
	  boolean bol_status = home.fun_LoggedInHomePgPresent();
	  genericFunction.fun_compareBolVariable(bol_status, true);
	  
	  //********************************************************************************************************
	  //Step : 3
	  strTestStepDescription = "Logout from application";
	  ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 3, strTestStepDescription);
	  
	  home.fun_logOut();
	  
	  //*********************************************************************************************************
	  //Step : 4
	  strTestStepDescription = "Validate that application is logged out successfully";
	  ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 4, strTestStepDescription);
	  
	  bol_status = login.fun_loginSignUpPgPresent();
	  genericFunction.fun_compareBolVariable(bol_status, true);
	  
	  //*********************************************************************************************************
  }
}

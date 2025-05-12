package testSuit;


import org.testng.annotations.Test;

import base.BaseClass;
import pages.*;
import utils.*;


public class TC01_RegisterNewUser extends BaseClass {
	
	
	@Test
	public void test() {

		GenericFunctionLib genericFunction = new GenericFunctionLib(objDriver, objExtentIndividualTest);
		LoginSignUp signUp = new LoginSignUp(objDriver);
		Registration register = new Registration(objDriver);
		AccountCreated accountCreate = new AccountCreated(objDriver);
		AccountDeleted accountDelete = new AccountDeleted(objDriver);
		Home home = new Home(objDriver);
		String strTestStepDescription;
		
		//*****************************************************************************************
		//Step : 1
		strTestStepDescription = "Enter Email and Username for Registration";
		ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 1, strTestStepDescription);
		
		signUp.fun_SignUp(MapTestData.get("Email"), MapTestData.get("UserName"));

		//*****************************************************************************************
		//Step : 2
		strTestStepDescription = "Validation for Registration page";
		ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 2, strTestStepDescription);
		
		genericFunction.fun_compareBolVariable(register.fun_registerationPgDisplayed(),true);
		
		//****************************************************************************************
		//Step : 3
		strTestStepDescription = "Register new user";
		ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 3, strTestStepDescription);
		
		register.fun_fillDetailAndClickSubmit(MapTestData.get("UserName"), "She@Steria987");
		
		//*******************************************************************************************
		//Step : 4
		strTestStepDescription = "Validate that user is registered and Message is displayed.";
		ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 4,  strTestStepDescription);
		
		genericFunction.fun_compareBolVariable(accountCreate.fun_validateAccountCreatedWithMsg(), true);
		accountCreate.fun_clickContinue();
		
		//*********************************************************************************************
		//Step : 5
		strTestStepDescription = "Click delete account link";
		ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 5,  strTestStepDescription);

		home.fun_deleteAccount();
		
		//*********************************************************************************************
		//Step : 6
		strTestStepDescription = "Validate that account is deleted and message is displayed";
		ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 6, strTestStepDescription);
		
		boolean bol_status = accountDelete.fun_validateAccountDeletedWithMsg();
		genericFunction.fun_compareBolVariable(bol_status, true);
		accountDelete.fun_clickContinue();
		
		//*********************************************************************************************
		//Step : 7
		strTestStepDescription = "Validate that Logout button not present";
		ReportLogger.fun_logInfoStepInReport(objDriver, objExtentIndividualTest, 7, strTestStepDescription);
		
		bol_status = home.fun_logoutNotPresent();
		genericFunction.fun_compareBolVariable(bol_status, true);
		
		//**********************************************************************************************
		
	}	
	

}

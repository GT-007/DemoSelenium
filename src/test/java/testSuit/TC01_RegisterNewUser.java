package testSuit;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.*;
import utils.*;


public class TC01_RegisterNewUser extends BaseClass {
	
	
	@Test
	public void registerNewUser() {

		LoginSignUp signUp = new LoginSignUp(objDriver);
		
		//*****************************************************************************************
		ReportLogger.fun_logStepInReport(objDriver, objExtentIndividualTest, Status.INFO, 1, 
				"Enter Email and Username for Registration");
		
		signUp.fun_SignUp(MapTestData.get("Email"), MapTestData.get("UserName"));

		//*****************************************************************************************

		ReportLogger.fun_logStepInReport(objDriver, objExtentIndividualTest, Status.INFO, 2, 
				"Validating for Registration page");
		
		Registration register = new Registration(objDriver);

		if (register.fun_registerationPgDisplayed()) {	
			ReportLogger.fun_logStepInReport(objDriver, objExtentIndividualTest, Status.PASS, 3, 
					"Registeration page displayed");
		} else {
			ReportLogger.fun_logStepInReport(objDriver, objExtentIndividualTest, Status.FAIL, 3,
					"Registeration page not displayed");			
		}
		//****************************************************************************************

		ReportLogger.fun_logStepInReport(objDriver, objExtentIndividualTest, Status.INFO, 4, 
				"Register new user");
		
		//register.fun_fillDetailAndClickSubmit("Gaurav Manral", "She@Steria987");
		
		

	}
}

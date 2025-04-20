package testSuit;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.*;
import utils.*;


public class TC01_RegisterNewUser extends BaseClass {
	
	
	@Test
	public void test() {

		LoginSignUp signUp = new LoginSignUp(objDriver);
		
		signUp.fun_SignUp(MapTestData.get("Email"), MapTestData.get("UserName"));

		Registration register = new Registration(objDriver);

		if (register.fun_registerationPgDisplayed()) {	
			ReportLogger.fun_logWithStepNoAndScreenshot(objDriver, objExtentIndividualTest, Status.PASS, 1, 
					"Registeration page displayed");
		} else {
			ReportLogger.fun_logWithStepNoAndScreenshot(objDriver, objExtentIndividualTest, Status.FAIL, 1,
					"Registeration page not displayed");			
		}

		/* register.fun_fillDetailAndClickSubmit("Gaurav Manral", "She@Steria987"); */
		
		

	}
}

package testSuit;

//import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.*;
import utils.ReportLogger;


public class TC01_RegisterNewUser extends BaseClass {
	@Test
	public void test() {

		LoginSignUp signUp = new LoginSignUp(driver);
		signUp.fun_SignUp("gauravma0r5@gmail.com", "Gaurav Manral");

		Registration register = new Registration(driver);
		// Assert.assertEquals(register.fun_registerationPgDisplayed(),true);
		if (register.fun_registerationPgDisplayed()) {
			ReportLogger.fun_logWithStepNoAndScreenshot(driver, test, Status.PASS, 1, "Registeration page displayed");
		} else {
			ReportLogger.fun_logWithStepNoAndScreenshot(driver, test, Status.FAIL, 1,
					"Registeration page not displayed");
		}

		/* register.fun_fillDetailAndClickSubmit("Gaurav Manral", "She@Steria987"); */

	}
}

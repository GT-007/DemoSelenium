//login >> validate login >> navigate to product>> Validate product page>>search ur polo Tshirt >> validate the Tshirt >> Logout>
package testSuit;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.Home;
import pages.LoginSignUp;
import pages.Product;
import utils.ReportLogger;


public class TC04_SearchProducts extends BaseClass{
  @Test
  public void SerachProducts() {
	  System.out.println("TC04_SearchProducts : Start");
	  LoginSignUp ObjLogin = new LoginSignUp(objDriver);
	  ObjLogin.fun_login("gauravmanral0@gmail.com", "She@Steria987");
	  Home objhome = new Home(objDriver);
	  objhome.fun_LoggedInHomePgPresent();
	  Product objproducts = new Product(objDriver);
	  objproducts.SearchItems("premium polo");
	  ReportLogger.fun_logWithStepNoAndScreenshot(objDriver, objExtentIndividualTest, Status.PASS, 1, "Registeration page displayed");	  
	  ReportLogger.fun_logWithStepNoAndScreenshot(objDriver, objExtentIndividualTest, Status.FAIL, 1, "Checking reporting");
	  objproducts.verifyProductResult();
	  System.out.println("TC04_SearchProducts : End"); 
	  System.out.println("TC04_SearchProducts : End"); 
	
  }
}



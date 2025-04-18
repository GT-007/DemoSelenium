package testSuit;


import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.*;

public class TC01_RegisterNewUser extends BaseClass{
  @Test
  public void test() {
	  
	  System.out.println("TC01_RegisterNewUser : Start");
	  
	  LoginSignUp signUp = new LoginSignUp(driver);
	  
	  Registration register = new Registration(driver);
	  Assert.assertEquals(register.fun_registerationPgDisplayed(),true);

	  register.fun_fillDetailAndClickSubmit("Gaurav Manral", "She@Steria987");
	  
	  System.out.println("TC01_RegisterNewUser : End");
  }
}


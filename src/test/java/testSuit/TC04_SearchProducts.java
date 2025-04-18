//login >> validate login >> navigate to product>> Validate product page>>search ur polo Tshirt >> validate the Tshirt >> Logout>
package testSuit;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Home;
import pages.LoginSignUp;
import pages.Product;


public class TC04_SearchProducts extends BaseClass{
  @Test
  public void SerachProducts() {
	  System.out.println("TC04_SearchProducts : Start");
	  LoginSignUp ObjLogin = new LoginSignUp(driver);
	  ObjLogin.fun_login("gauravmanral0@gmail.com", "She@Steria987");
	  Home objhome = new Home(driver);
	  objhome.fun_LoggedInHomePgPresent();
	  Product objproducts = new Product(driver);
	  objproducts.SearchItems("premium polo");
	  objproducts.verifyProductResult();
	  System.out.println("TC04_SearchProducts : End"); 
	
  }
}



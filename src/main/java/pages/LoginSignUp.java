package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignUp {

	WebDriver driver;
	
	//******* Login objects **********
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement txt_emailAddLogin;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement txt_password;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement btn_loginIn;
	
	//******** Sign up objects **********
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement txt_emailAddSignUp;
	
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	private WebElement txt_name;
	
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement btn_signUp;
	
	//****** class constructor *********
	public LoginSignUp(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);	
	}
	
	public void fun_login(String strEmail, String strPassword)
	{
		System.out.println("fun_login : Start");
		
		txt_emailAddLogin.sendKeys(strEmail);
		txt_password.sendKeys(strPassword);
		btn_loginIn.click();
		
		System.out.println("fun_login : End");
        	
	}
	
	public void fun_SignUp(String strEmail, String strName)
	{
		System.out.println("fun_SignUp : Start");
		
			txt_emailAddSignUp.sendKeys(strEmail);
			txt_name.sendKeys(strName);
			btn_signUp.click();
			
		System.out.println("fun_SignUp : End");
	}
}

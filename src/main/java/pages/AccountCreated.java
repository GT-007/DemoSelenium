package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreated {

	WebDriver driver;
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	private WebElement wel_accountCreated;
	
	@FindBy(xpath = "//p[text()='Congratulations! Your new account has been successfully created!']")
	private WebElement wel_creationMsg;
	
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	private WebElement btn_continue;
	
	public AccountCreated(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean fun_validateAccountCreatedWithMsg()
	{
		if (wel_accountCreated.isDisplayed() && wel_creationMsg.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void fun_clickContinue()
	{
		btn_continue.click();
	}
	
	
}

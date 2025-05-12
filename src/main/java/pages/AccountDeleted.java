package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeleted {
	
	WebDriver driver;
	
	@FindBy(xpath="//b[text()='Account Deleted!']")
	WebElement wel_accountDeleted;
	
	@FindBy(xpath = "//p[text()='Your account has been permanently deleted!']")
	private WebElement wel_deleteMsg;
	
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	private WebElement btn_continue;
	
	public AccountDeleted(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean fun_validateAccountDeletedWithMsg()
	{
		if (wel_accountDeleted.isDisplayed() && wel_deleteMsg.isDisplayed())
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

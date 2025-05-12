package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement lnk_logout;

	@FindBy(xpath = "//a[@href='/delete_account']")
	private WebElement lnk_deleteAccount;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public Home(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	public boolean fun_LoggedInHomePgPresent()
	{
		
		try {
			wait.until(ExpectedConditions.visibilityOf(lnk_logout));
		}
		catch(TimeoutException e){
			return false;
		}
		
		return true;
		
	}
	
	public boolean fun_logoutNotPresent()
	{
		List<WebElement> lnk_logOut1 = driver.findElements(By.xpath("//a[@href='/logout']"));
		
		if(lnk_logOut1.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void fun_logOut()
	{
		lnk_logout.click();		
	}
	
	public void fun_deleteAccount()
	{
		wait.until(ExpectedConditions.visibilityOf(lnk_deleteAccount));
		lnk_deleteAccount.click();
		
				
	}
}

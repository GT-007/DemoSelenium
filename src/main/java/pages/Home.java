package pages;

import java.time.Duration;

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

	Home(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	public boolean fun_LoggedInHomePgPresent()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(lnk_logout));
		}
		catch(TimeoutException e){
			return false;
		}
		
		return true;
		
	}
}

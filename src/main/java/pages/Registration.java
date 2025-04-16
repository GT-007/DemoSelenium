package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
	
	WebDriver driver;
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement wel_registerationHeader;
	
	@FindBy(xpath = "//input[@data-qa='password']")
	private WebElement txt_password;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement rdn_selectGender;
	
	@FindBy(xpath = "//select[@data-qa='days']")
	private WebElement lst_selectDays;
	
	@FindBy(xpath = "//select[@data-qa='months']")
	private WebElement lst_selectMonths;	

	@FindBy(xpath = "//select[@data-qa='years']")
	private WebElement lst_selectYears;	

	@FindBy(xpath = "//input[@data-qa='first_name']")
	private WebElement txt_firstName;
	
	@FindBy(xpath = "//input[@data-qa='last_name']")
	private WebElement txt_lastName;
	
	@FindBy(xpath = "//input[@data-qa='address']")
	private WebElement txt_address;
	
	@FindBy(xpath = "//input[@data-qa='state']")
	private WebElement txt_state;

	@FindBy(xpath = "//input[@data-qa='city']")
	private WebElement txt_city;
	
	@FindBy(xpath = "//input[@data-qa='zipcode']")
	private WebElement txt_zipcode;
	
	@FindBy(xpath = "//input[@data-qa='mobile_number']")
	private WebElement txt_mobileNumber;
	
	@FindBy(xpath = "//button[@data-qa='create-account']")
	private WebElement btn_Submit;
	
	public Registration(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

	public boolean fun_registerationPgDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(wel_registerationHeader));
		}
		catch(TimeoutException e){
			return false;
		}
		
		return true;
		
	}
	
	public void fun_fillDetailAndClickSubmit(String strUsername, String strPassword)
	{
		Select ListDay1, ListMonth1, ListYear1;
		
		rdn_selectGender.click();
		txt_password.sendKeys(strPassword);

		ListDay1 = new Select(lst_selectDays);
		ListDay1.selectByVisibleText("4");
		
		ListMonth1 = new Select(lst_selectMonths);
		ListMonth1.selectByVisibleText("July");
		
		ListYear1 = new Select(lst_selectYears);
		ListYear1.selectByVisibleText("1996");

		String[] arrUser = strUsername.split(String.valueOf(" "));

		txt_firstName.sendKeys(arrUser[0]);
		txt_lastName.sendKeys(arrUser[1]);

		txt_address.sendKeys("XYZ, ABC");
		txt_state.sendKeys("Delhi");
		txt_city.sendKeys("New Delhi");
		txt_zipcode.sendKeys("110096");
		txt_mobileNumber.sendKeys("9717355141");
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		btn_Submit.click();
		
	}
}

/*
SelectGender =  driver.findElement(By.xpath("//input[@id='id_gender1']"));
		SelectGender.click();
		
		PasswordTextBox =  driver.findElement(By.xpath("//input[@data-qa='password']"));
		PasswordTextBox.sendKeys(strPassword);
		

		ListDay = driver.findElement(By.xpath("//select[@data-qa='days']"));
		ListMonth = driver.findElement(By.xpath("//select[@data-qa='months']"));
		Listyear = driver.findElement(By.xpath("//select[@data-qa='years']"));
		
		ListDay1 = new Select(ListDay);
		ListDay1.selectByVisibleText("4");
		
		ListMonth1 = new Select(ListMonth);
		ListMonth1.selectByVisibleText("July");
		
		ListYear1 = new Select(Listyear);
		ListYear1.selectByVisibleText("1996");
		
		String[] arrUser = strUsername.split(String.valueOf(" "));

		FirstName =  driver.findElement(By.xpath("//input[@data-qa='first_name']"));
		FirstName.sendKeys(arrUser[0]);
		
		LastName =  driver.findElement(By.xpath("//input[@data-qa='last_name']"));
		LastName.sendKeys(arrUser[1]);


		Address =  driver.findElement(By.xpath("//input[@data-qa='address']"));
		Address.sendKeys("XYZ, ABC");

		State =  driver.findElement(By.xpath("//input[@data-qa='state']"));
		State.sendKeys("Delhi");
		
		City =  driver.findElement(By.xpath("//input[@data-qa='city']"));
		City.sendKeys("New Delhi");

		Zipcode =  driver.findElement(By.xpath("//input[@data-qa='zipcode']"));
		Zipcode.sendKeys("110096");
		
		PhoneNo =  driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
		PhoneNo.sendKeys("9717355141");
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		SubmitButton =  driver.findElement(By.xpath("//button[@data-qa='create-account']"));
	
		SubmitButton.click();
		

		AccountCreated =  driver.findElement(By.xpath("//b[text()='Account Created!']"));
		System.out.println("Account created Succesfully with message : " +AccountCreated.getText());
		
		System.out.println("fun_RegisterUser : End");

*/
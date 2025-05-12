package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	
	WebDriver driver;
	//**********HomePage>Product***************
	@FindBy(xpath = "//a[@href='/products']")
	private WebElement btn_products;
	
	//********Object on Products Page**********
	@FindBy(xpath = "//input[@id='search_product']")
	private WebElement txt_searchbox;
	
	@FindBy(xpath = "//button[@id='submit_search']")
	private WebElement btn_search;
	
	@FindBy(xpath = "//p[text()='Premium Polo ']")
	private WebElement wel_Product;
	
	
	//****** class constructor *********
		public Product(WebDriver driver1)
		{
			driver = driver1;
			PageFactory.initElements(driver, this);	
		}
		
		public void SearchItems(String Items)
		{
			System.out.println("SearchItems : Start");
			
			btn_products.click();
			if(txt_searchbox.isDisplayed())
			{
			System.out.println("SusscesfullyNavigated on Product Page");
			}
			else 
			{
			System.out.println("Not Navigated to Product Page");
			}
			
			txt_searchbox.sendKeys(Items);
			btn_search.click();
			
			System.out.println("SearchItems : End");
	        	
		}
		 public  void verifyProductResult() {
		        
		        if (wel_Product.isDisplayed()) {
		            System.out.println("Product is displayed after click on Search Button");
		        } else {
		            System.out.println("Product is Not displayed after click on Search Button");
		        }
		    }
		
	}


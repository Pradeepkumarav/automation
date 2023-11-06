package mercurytours_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Reusable.Reausablesteps;
import mercurytour_utilities.Readconfig;

public class Mercurytourpage_login {

	Readconfig config=new Readconfig();
	Reausablesteps reause=new Reausablesteps();
	String usernamelogin = config.getUsername();
	String passwordlogin=config.getPassword();
    WebDriver driver;
    
	public Mercurytourpage_login(WebDriver remotedriver)
	{
		driver = remotedriver;
		PageFactory.initElements(remotedriver, this);;
	}
	
	//locating web elements present on the web page
	
	
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-ON')]")

	WebElement Signon;
	
	//locating FirstName from Create User page
	@FindBy(name = "userName")
	@CacheLookup
	WebElement username;
	
	//locating LastName from Create User page
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "submit")
	@CacheLookup
	WebElement loginsubmit;
	
	@FindBy(xpath = "//h3[text()='Login Successfully']")
	@CacheLookup
	WebElement Loginsuccess;
	
	 public void clickonsignon() throws InterruptedException {
			
		    reause.click(driver, Signon);
		    Thread.sleep(1000);
		    
		    
		   try {
			driver.findElement(By.xpath("//b[contains(text(),'Password:')]"));
			// System.out.println(data1);
			
			    Thread.sleep(1000);
			   /* if(data1.equalsIgnoreCase("Password:"))
			    {
			    	System.out.println(data1);
			    	
			    }
			    else
			    {
			    	
			    	// System.out.println("hii");
			    	//  throw new Exception();
			      
			    }*/
		   }
		   catch(Exception e)
		   {
				
			   driver.navigate().back();
				Thread.sleep(4000);
				 reause.click(driver, Signon);
		   }
			
		
			
			
			
		}
	 public void enterusernamelogin() {
			reause.sendKeys(username, driver, usernamelogin);
		}
	
	public void enterpasslogin() {
		
		reause.sendKeys( password, driver,   passwordlogin );
	}
	
	public void loginsubmit() {
		reause.click(driver, loginsubmit);
	}
	
	public void loginvalidation() {
		String text=reause.getText(driver, Loginsuccess);
		System.out.println(text);
		Assert.assertEquals(text, "Login Successfully");
		
	}
	
	
	
}

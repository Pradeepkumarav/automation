package mercurytours_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mercury_addcart {

	WebDriver driver;
	public Mercury_addcart(WebDriver remotedriver)
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
}

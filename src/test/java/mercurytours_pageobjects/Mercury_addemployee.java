package mercurytours_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mercury_addemployee {

WebDriver driver;
    
	public Mercury_addemployee(WebDriver remotedriver)
	{
		driver = remotedriver;
		PageFactory.initElements(remotedriver, this);;
	}
	
	//locating web elements present on the web page
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Flights')]")
	@CacheLookup
	WebElement  flight;
	

	@FindBy(xpath = "//input[@value='oneway']")
	@CacheLookup
	WebElement  onewaycheckbox;
	
}

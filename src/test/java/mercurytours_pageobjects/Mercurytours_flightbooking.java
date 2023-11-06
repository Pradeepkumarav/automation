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

public class Mercurytours_flightbooking {

	Readconfig config=new Readconfig();
	Reausablesteps reause=new Reausablesteps();
	String usernamelogin = config.getUsername();
	String passwordlogin=config.getPassword();
    WebDriver driver;
    
	public Mercurytours_flightbooking(WebDriver remotedriver)
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
	
	@FindBy(xpath = "//select[@name='passCount']")
	@CacheLookup
	WebElement  passenger;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	@CacheLookup
	WebElement  Departfrom;
	
	@FindBy(xpath = "//select[@name='toPort']")
	@CacheLookup
	WebElement  Arriveto;
	
	@FindBy(xpath = "//input[@value='First']")
	@CacheLookup
	WebElement  serviceclass;
	
	@FindBy(xpath = "//select[@name='airline']")
	@CacheLookup
	WebElement  airline;
	
	@FindBy(xpath = "//input[@name='findFlights']")
	@CacheLookup
	WebElement  flightcontinue;
	
	
	@FindBy(xpath = "//img[@src='images/home.gif']")
	@CacheLookup
	WebElement Backtohome;
	
	public void clickonflight() throws InterruptedException {
		reause.click(driver, flight);
		Thread.sleep(1000);
	    
	         
		  try {
			  driver.findElement(By.xpath("//input[@value='oneway']"));
			
			/*System.out.println("pradeep");
				if(condition1==true)
				{
					System.out.println("kumara");
				}
				else
				{
					System.out.println("pradeep123");
					driver.navigate().back();
					Thread.sleep(4000);
					 reause.click(driver, flight);
				}*/
			
			
			
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
				System.out.println("no");
			   driver.navigate().back();
				Thread.sleep(4000);
				 reause.click(driver, flight);
		   }
	}
	
	public void clickononeway() {
		reause.click(driver, onewaycheckbox);
	}
	
	public void passengerdropdown() {
		reause.dropdown(driver, passenger, "3" );
	}
	
	public void Departingfrom() {
		reause.dropdown(driver,Departfrom, "Sydney" );
	}
	
	public void Departingto() {
		reause.dropdown(driver, Arriveto, "London" );
	}
	
	public void Serviceclassselect() {
		reause.click(driver, serviceclass);
	}
	
	public void airlinedropdown() {
		reause.dropdown(driver, airline, "Unified Airlines");
	}
	
	public void clickcontinue() {
		reause.click(driver, flightcontinue);
	}
	
	public void valiadtionflight() {
		  Boolean condition= Backtohome.isDisplayed();
		Assert.assertTrue(condition, "user able to see the flghts");
	}
	
	
}

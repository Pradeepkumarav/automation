package mercurytours_pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Reusable.Reausablesteps;
import mercurytour_utilities.Readtestdata;


public class Mercurytours_register {

	
	Reausablesteps reause=new Reausablesteps();
    WebDriver driver;
    
    Readtestdata execelldata=new Readtestdata();
	
	//constructor
	public Mercurytours_register(WebDriver remotedriver)
	{
		driver = remotedriver;
		PageFactory.initElements(remotedriver, this);;
	}
	
	//locating web elements present on the web page
	
	@FindBy(xpath = "//a[text()='REGISTER']")
	@CacheLookup
	WebElement register;
	
	//locating FirstName from Create User page
	@FindBy(name = "firstName")
	@CacheLookup
	WebElement firstName;
	
	//locating LastName from Create User page
	@FindBy(name = "lastName")
	@CacheLookup
	WebElement lastname;
	
	//locating LastName from Create User page
	@FindBy(name = "phone")
	@CacheLookup
	WebElement mobilenumber;
	
	//locating Address Line1 from Create User page
	@FindBy(name = "userName")
	@CacheLookup
	WebElement email ;
	
	@FindBy(name = "country")
	@CacheLookup
	WebElement countrydropdown ;
	
	//locating Address Line2 from Create User Page
	@FindBy(name = "email")
	@CacheLookup
	WebElement username ;
	
	//locating Address Line2 from Create User Page
	@FindBy(name = "password")
	@CacheLookup
	WebElement password ;
	
   //locating Address Line2 from Create User Page
	@FindBy(name = "confirmPassword")
	@CacheLookup
	WebElement confirmpass ;
	
	@FindBy(name = "submit")
	@CacheLookup
	WebElement submit ;
	
	@FindBy(xpath = "//b[contains(text() ,'pradeepkumara.')]")
	@CacheLookup
	WebElement validateusername ;
	
	String[][] arrObj=registerexcelldata();
	
    
         public String[][] registerexcelldata( )   {
        	 String[][] arrObj = null;
			try {
				arrObj = execelldata.getExcelData(
				         "C:\\Users\\Pradeep\\Documents\\checking\\New.xls","Register");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           return arrObj;
		
	}
         
    public void clickonregister() {
			reause.click(driver, register);
		}
	
	public void enterfirstname() {
		
		reause.sendKeys( firstName, driver,   arrObj[1][0] );
	}
	
	public void enterlastname() {
		reause.sendKeys( lastname, driver, arrObj[1][1]);
	}
	
	public void entermobile() {
		reause.sendKeys( mobilenumber, driver,arrObj[1][2]);
	}
	public void enteremail() {
		reause.sendKeys( email, driver, arrObj[1][3]);
	}
	
	public void enterdropdown() {
	
		reause.dropdown(driver, countrydropdown, arrObj[1][4]);
	}
	
	public void enterusername() {
		reause.sendKeys( username, driver, arrObj[1][5]);
	}
	
	public void entepassword() {
		reause.sendKeys( password, driver, arrObj[1][6]);
	}
	
	public void enteconfirm() {
		reause.sendKeys( confirmpass, driver, arrObj[1][7]);
	}
	
	public void submit() {
		reause.click( driver, submit);
	}
	
	public void validateregistered() {
		String text=reause.getText(driver, validateusername);
		System.out.println(text);
		Assert.assertEquals(text, "Note: Your user name is pradeepkumara.");
	
		
	}
	
	
	
	
}

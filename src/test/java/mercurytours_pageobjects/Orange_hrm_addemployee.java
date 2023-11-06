package mercurytours_pageobjects;

import java.io.IOException;
import java.util.List;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reusable.Reausablesteps;
import mercurytour_utilities.Readtestdata;

public class Orange_hrm_addemployee {

	Reausablesteps reause=new Reausablesteps();
	Readtestdata execelldata=new Readtestdata();
	 WebDriver driver;
	public Orange_hrm_addemployee(WebDriver remotedriver)
	{
		driver = remotedriver;
		PageFactory.initElements(remotedriver, this);;
	}
	
	//locating web elements present on the web page
	
	@FindBy(name = "username")
	@CacheLookup
	WebElement username;
	
	//locating FirstName from Create User page
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	@CacheLookup
	WebElement Loginbutton;
	
	@FindBy(xpath = "//span[normalize-space()='PIM']")
	@CacheLookup
	WebElement PIM;
	
	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	@CacheLookup
	WebElement Addemployee;
	
	@FindBy(name = "firstName")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(name = "middleName")
	@CacheLookup
	WebElement middlename;
	
	@FindBy(name = "lastName")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	@CacheLookup
	WebElement Employeeid;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	@CacheLookup
	WebElement save;
	
	@FindBy(xpath = "//a[contains(text(),'Employee List')]")
	@CacheLookup
	WebElement Employeelist;

	String[][] arrObj=registerexcelldata();
	
    
    public String[][] registerexcelldata( )   {
   	 String[][] arrObj = null;
		try {
			arrObj = execelldata.getExcelData(
			         "C:\\Users\\Pradeep\\Documents\\checking\\New.xls","Addemployee");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return arrObj;
	
}	
	
   public void addusername() {
	reause.sendKeys(username, driver, "Admin");
   }
   
   public void addpossword() {
		reause.sendKeys(password, driver, "admin123	");
	}
   
   public void clicksubmit() {
		reause.click(driver, Loginbutton);
	}
   
   public void clickPIM() {
		reause.click(driver, PIM);
		
	}
   
   public void clickaddemployee() {
		reause.click(driver, Addemployee);
		
	}
   
   public void enterfirstname() {
		reause.sendKeys(firstname, driver, arrObj[1][0]);
		
	}
   
   public void entermidlename() {
		reause.sendKeys(middlename, driver, arrObj[1][1]);
		
	}
   public void enterlastname() {
		reause.sendKeys(lastname, driver, arrObj[1][2]);
		
	}
   
   public void enteremployeeid() {
	    
		reause.sendKeys(Employeeid, driver, arrObj[1][3]);
		
	}
   
   public void clicksave() {
		reause.click(driver, save);
		
	}
     
   public void clickemployeelist() {
		reause.click(driver, Employeelist);
		
		
	}
  
   public void validation() throws Exception {
	int count=driver.findElements(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[2]/div")).size();
	System.out.println(count);
	List<WebElement> employeeid=driver.findElements(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[2]/div"));
	
	boolean result=false;
	for (WebElement element : employeeid) {
		String id=element.getText();
		
		
		
		if(id.equals(arrObj[1][3]))
		{
			System.out.println("employeeid  "+ id); 
		    result=true;
		     break;
		}
		else
		{
			//System.out.println("false"  + id); 
			result=false;
		}
		
	}
	
	
	if(result==true)
	{
		System.out.println("employee data added to table");
	}
	else
	{
		throw new Exception("employee data not added to table");
	}
}
   
    /*public void Addingemployeedata() throws Exception {
    	
    WebElement elemnts[]= {firstname, middlename,lastname,Employeeid};
   
	for(int i=1;i<4;i++)
	{
		 
		/*int attempts = 0;
	    while(attempts < 3) {
	  try {
	           System.out.println("k");
	        	reause.click(driver, Addemployee);
	           System.out.println("p");
	               break;
	       }     catch(StaleElementReferenceException e)
	         {
	    	   System.out.println("c");
	         }
	        attempts++;
	   }*/
		
		
		//new WebDriverWait(driver, Duration.ofSeconds(50)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(Addemployee));
		//Addemployee.click();
		
		/*new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.refreshed(
		ExpectedConditions.elementToBeClickable(Addemployee)));
	    
		       Addemployee.click();
		
		while (true) { // loops forever until break
		    try { // checks code for exceptions
		    	new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.refreshed(
				ExpectedConditions.elementToBeClickable(Addemployee)));
			    
				       Addemployee.click();
		        break; // if no exceptions breaks out of loop
		    } 
		    catch (org.openqa.selenium.StaleElementReferenceException e1) { 
		        Thread.sleep(3000); // you can set your value here maybe 2 secs
		        continue; // continues to loop if exception is found
		    }
		} 
	     Thread.sleep(2000);
		for(int j=0; j<4;j++)
		{	
			Thread.sleep(2000);
			elemnts[j].clear();
			Thread.sleep(1000);
			reause.sendKeys(elemnts[j], driver, arrObj[i][j]);
		}
		reause.click(driver, save);
	}
		
}*/

   
	
}

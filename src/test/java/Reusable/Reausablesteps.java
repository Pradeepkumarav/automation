package Reusable;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class Reausablesteps {

	
	public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeout) {

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        WebElement elmnt = wait.until(ExpectedConditions.elementToBeClickable(element));
        return elmnt;
        
    }
	
	public void sendKeys( WebElement element,WebDriver driver, String sendkey) {
    	if(element!=null) {
    		waitForElementToBeClickable(driver, element, 10);
            element.isDisplayed();
            element.clear();
            element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            element.sendKeys(sendkey);
    	}
    	else {
    		System.out.println(element + "is not present or not editable");
    	     
    	     }
    }
	
	 public void click(WebDriver driver, WebElement element) {
	    	if(element!=null) {
	    		waitForElementToBeClickable(driver, element, 10);
	            element.isDisplayed();
	            element.click();
	    	}
	    	else {
	    		System.out.println(element + "is not present or not clickable");
	    	}
	    }
	 
	 public String getText(WebDriver driver, WebElement element) {
	    	String get_text = "";
	    	if(element!=null) {
	    		waitForElementToBeClickable(driver, element, 20);
	            element.isDisplayed();
	            get_text = element.getText();
	    	}
	    	else {
	    		System.out.println(element + "is not dispalyed");
	    	}
	    	
	    	return get_text;
	    }
	 
	 public void dropdown(WebDriver driver, WebElement element, String dropdowntext) {
	    	
	    	if(element!=null) {
	    		waitForElementToBeClickable(driver, element, 20);
	            element.isDisplayed();
	            Select objSelect =new Select(element);
	            objSelect.selectByVisibleText(dropdowntext);
	    	}
	    	else {
	    		System.out.println(element + "is not dispalyed");
	    	}
	    	
	    	
	    }
	 

	 
	 public void dropdown1(WebDriver driver, WebElement element, String dropdowntext) {

	    	
	    	if(element!=null) {
	    		waitForElementToBeClickable(driver, element, 20);
	            element.isDisplayed();
	            Select objSelect =new Select(element);
	            objSelect.selectByVisibleText(dropdowntext);
	    	}
	    	else {
	    		System.out.println(element + "is not dispalyed");
	    	}
	    	
	    	
	    }
	
	
}

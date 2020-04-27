package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMTestBase;

public class LoginPage extends CRMTestBase {
	
	//Page Factory
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
    WebElement crmLogo;
	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
    //actions
		public String validateCrmPageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean validateCrmLogoImage()
		{
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd) {
			
			userName.sendKeys(un);
			password.sendKeys(pwd);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", loginBtn);
	    	
	    	return new HomePage();
			
		}
}

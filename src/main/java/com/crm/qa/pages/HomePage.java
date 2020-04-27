package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMTestBase;

public class HomePage extends CRMTestBase {

	//page factories
	@FindBy(xpath="//td[contains(text(),'User: Demo User ')]")
	WebElement userNameTest;
	
	@FindBy(xpath="//a[contains(@title,'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(@title,'New Contact')]")
	WebElement newContactLink;
	
	//Initializing the Page Objects:
			public HomePage(){
				PageFactory.initElements(driver, this);
			}
			
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCurrectUserNameTest()
	{
		return userNameTest.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		 contactLink.click();
		 return new ContactsPage();
		 
	}
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();		
		
	}
}

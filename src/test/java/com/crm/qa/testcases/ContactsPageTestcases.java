package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTestcases extends CRMTestBase {

	LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;
    
    String sheetName = "contacts";
    
    public ContactsPageTestcases(){
		super();
	}
    
    @BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
	}
    @Test(priority=1)
    public void verifyContactsPageLable()
    {
    	
    	Assert.assertTrue(contactsPage.verifyContacstLable(),"contacts lable is missing on the page");
    }
    @Test(priority=2)
    public void contactsTest()
    {
    	contactsPage.selectContactsByName("David Cris");
    	contactsPage.selectContactsByName("da ca");
    }
    
    @DataProvider
	public Object[][] getCrmTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}    
    
    @Test(priority=3,dataProvider="getCrmTestData")
    public void validateCreatNewContact(String title,String firstname, String lastname, String company )
    {
    	homePage.clickOnNewContactLink();
    	//contactsPage.createNewContact("Mr.", "vinathi", "Balu", "Google");
    	contactsPage.createNewContact(title, firstname, lastname, company);
    }
    
    
    @AfterMethod
    public void tearDown()
    {
    	
    	driver.quit();
    	
    }

	
}

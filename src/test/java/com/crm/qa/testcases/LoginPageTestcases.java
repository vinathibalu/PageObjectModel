package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTestcases extends CRMTestBase {

	LoginPage loginPage;
    HomePage homePage;
    
    public LoginPageTestcases(){
		super();
	}
    
    @BeforeMethod
    public void setUp() {
    	initialization();
    	loginPage = new LoginPage();
        	
    }
    
    @Test(priority=1)
    public void crmLogoImgTest()
    {
    
    	boolean flag=loginPage.validateCrmLogoImage();
    	Assert.assertTrue(flag);
    	
    }
    @Test(priority=2)
    public void crmTitleTest()
    {
    	String title=loginPage.validateCrmPageTitle();
    	Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
    }
    
    @Test(priority=3)
    public void loginTest()
    {
    	homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
    {
    	
    }
    
    @AfterMethod
    public void tearDown()
    {
    	
    	driver.quit();
    	
    }
	
	
}

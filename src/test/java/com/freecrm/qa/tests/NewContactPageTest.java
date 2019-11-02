package com.freecrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.NewContactPage;
import com.freecrm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactPage newContactPage;
	
	public NewContactPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setuP(){
		intializeBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.verifyLogin(p.getProperty("username"), p.getProperty("password"));
		
		newContactPage = homePage.clickOnNewContact();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	@Test(dataProvider="getData")
	public void validateNewContact(String title,String fname,String lname){
		newContactPage.addNewContact(title, fname, lname);
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] data = TestUtil.getTestData("ContactsTestData");
		return data;
	}
}

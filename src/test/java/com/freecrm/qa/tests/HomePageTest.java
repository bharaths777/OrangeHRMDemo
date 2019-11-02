package com.freecrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.DealsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.TasksPage;
import com.freecrm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	public TasksPage tasksPage;
	public DealsPage dealsPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intializeBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.verifyLogin(p.getProperty("username"), p.getProperty("password"));
		
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		tasksPage = new TasksPage();
		dealsPage = new DealsPage();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	@Test(priority=1)
	public void validateUserLabel(){
		boolean flag = homePage.verifyUserLabel();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void validateHomePageTitle(){
		
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	@Test(priority=3)
	public void validateContactsPage(){
		
		homePage.clickOnContacts();
	}
	@Test(priority=4)
	public void validateDealsPage(){
		homePage.clickOnDeals();
	}
	@Test(priority=5)
	public void validateTasksPage(){
		homePage.clickOnTasks();
	}
	
	@Test(priority=6)
	public void validateNewContactPage(){
		homePage.clickOnNewContact();
	}
}

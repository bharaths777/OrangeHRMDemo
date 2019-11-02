package com.freecrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intializeBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.verifyLogin(p.getProperty("username"),
				p.getProperty("password"));
		
		contactsPage = homePage.clickOnContacts();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void validateContactsLable() {
		boolean flag = contactsPage.verifyContactsLable();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void validateContact() {
		contactsPage.verifyContact();
	}

}

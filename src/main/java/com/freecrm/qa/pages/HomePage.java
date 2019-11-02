package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: bharath kumar')]")
	WebElement userLabel;
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsTab;
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsTab;
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksTab;
	@FindBy(xpath="//a[contains(text(),'New Contact')]") WebElement newContact;
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyUserLabel() {
		TestUtil.moveToFrame();
		boolean flag = userLabel.isDisplayed();
		return flag;

	}

	public String verifyHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public ContactsPage clickOnContacts() {
		
		TestUtil.moveToFrame();
		/*Actions a = new Actions(driver);
		a.moveToElement(contactsTab);*/
		contactsTab.click();

		return new ContactsPage();
	}

	public DealsPage clickOnDeals() {
		TestUtil.moveToFrame();
		/*Actions a = new Actions(driver);
		a.moveToElement(dealsTab);*/
		dealsTab.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasks() {
		TestUtil.moveToFrame();
		/*Actions a = new Actions(driver);
		a.moveToElement(tasksTab);*/
		tasksTab.click();

		return new TasksPage();
	}
	
	public  NewContactPage clickOnNewContact(){
		TestUtil.moveToFrame();

		Actions a = new Actions(driver);
		a.moveToElement(contactsTab).build().perform();
		newContact.click();
		
		return new NewContactPage();
		
	}
	
	

}

package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]") WebElement contactslabel;
	@FindBy(xpath="//a[contains(text(),'bharath kumar')]") WebElement contact;
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyContactsLable(){
		
		boolean flag = contactslabel.isDisplayed();
		return flag;
		
	}
	public void verifyContact(){
		contact.click();
	}
}

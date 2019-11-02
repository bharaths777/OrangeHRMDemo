package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.TestBase;

public class NewContactPage extends TestBase{
	
	
	@FindBy(xpath="//select[@name='title']") WebElement titleDropDown;
	
	@FindBy(id="first_name") WebElement fname;
	@FindBy(id="surname")WebElement surname;
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]") WebElement savebtn;
	
	
	
	public NewContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void addNewContact(String title,String firstname,String surName){
		
		Select s = new Select(titleDropDown);
		s.selectByVisibleText(title);
		fname.sendKeys(firstname);
		surname.sendKeys(surName);
		savebtn.click();
	}

}

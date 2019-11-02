package com.freecrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pwd;
	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement loginbtn;
	@FindBy(className = "img-responsive")
	WebElement logo;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean verifyLoginPageLogo() {
		boolean flag = logo.isDisplayed();
		return flag;
	}

	public String verifyLoginPageTitle() {

		String title = driver.getTitle();
		return title;
	}

	public HomePage verifyLogin(String userName, String password) {
		uname.sendKeys(userName);
		pwd.sendKeys(password);
		
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", loginbtn);
		
		return new HomePage();
	}

}

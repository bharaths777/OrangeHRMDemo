package com.freecrm.qa.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.Log;
import com.freecrm.qa.util.ScreeShots;

public class LoginPageTest extends TestBase {

	public LoginPage loginPage;
	public ExtentTest logger;

	LoginPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		
		intializeBrowser();
		loginPage = new LoginPage();
		logger = report.createTest("Login page test");
		Log.info("FREE CRM APP launched successfully...");
	}


	@Test(priority = 1)
	public void validateLoginPageLogo() {

		logger.info("login page logo test");
		boolean flag = loginPage.verifyLoginPageLogo();
		Assert.assertTrue(flag);
		System.out.println("LOGO TEST SUCCESSFULL");
		System.out.println("logo 2");
		logger.pass("login page logo test successfull");
		System.out.println("brach changes");

	}

	@Test(priority = 2)
	public void validateLoginPageTitle() {

		logger.info("login page title test");
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title,
				"CRMPRO - CRM software for customer relationship management, sales, and suppor");

		System.out.println("TITLE TEST SUCCESSFULL");
		logger.pass("login page logo test successfull");
		System.out.println("title 2");
	}

	@Test(priority = 3)
	public void validateLogin() {

		report.createTest(" Login verification test");
		logger.info("login validation");
		loginPage.verifyLogin(p.getProperty("username"),
				p.getProperty("password"));
		
		System.out.println("LOGIN VALIDATION SUCCESSFULL");

		logger.info("free crm login Successfull");
		System.out.println("brach changes");

	}
	
	

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String lpath = ScreeShots.getScreenShot();
			try {
				logger.fail(result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(lpath)
								.build());
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	

		report.flush();
		driver.quit();
		logger.info("login page closed successfully");
		Log.info("Free crm app closed successfully..");
		System.out.println("brach changes");
	}
	
	
	
	

}

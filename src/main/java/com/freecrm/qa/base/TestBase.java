package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.freecrm.qa.util.TestUtil;

public class TestBase {

	public static Properties p;
	public static WebDriver driver;
	public static ExtentReports report;

	public TestBase() {

		try {
			p = new Properties();
			FileInputStream fis = new FileInputStream(
					"G:\\Bharathi-Bharath\\work\\CRMTest\\src\\main\\java\\com\\freecrm\\qa\\config\\config.properties");

			p.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void intializeBrowser() {
		String browser = p.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"G:\\Bharathi-Bharath\\work\\CRMTest\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts()
				.pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));

	}
	
	@BeforeSuite
	public void setUp(){
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter("G:\\Bharathi-Bharath\\work\\CRMTest\\Reports\\CRMTestReports.html");
		report = new ExtentReports();
		report.attachReporter(extent);
		
		
	}

}

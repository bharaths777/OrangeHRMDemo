package com.freecrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.freecrm.qa.base.TestBase;

public class ScreeShots extends TestBase{
	
	public static String getScreenShot(){
		
		TakesScreenshot screeshot = ((TakesScreenshot) driver);
		File src = screeshot.getScreenshotAs(OutputType.FILE);
	    String path = System.getProperty("user.dir")+"/ScreenShots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
	    try {
			FileHandler.copy(src, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    return path;
	}

}

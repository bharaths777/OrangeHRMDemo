package com.freecrm.qa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




public class Log {
	
	public static Logger log = Logger.getLogger("Log.class");
	
	
	public static void info(String message){
		
	PropertyConfigurator.configure("G:\\Bharathi-Bharath\\work\\CRMTest\\src\\main\\java\\com\\freecrm\\qa\\config\\log4j.properties");
	
	log.info(message);
	}
	

}

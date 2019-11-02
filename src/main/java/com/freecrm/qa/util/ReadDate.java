package com.freecrm.qa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadDate {
	
	public static void getCurrentDateTime(){
	
	DateFormat cformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentdate = new Date();
	cformat.format(currentdate);
	
	}
	

}

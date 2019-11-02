package com.freecrm.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.freecrm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static XSSFWorkbook wb ;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis ;
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;
	public static String FILE_PATH = "G:\\Bharathi-Bharath\\work\\CRMTest\\src\\main\\java\\com\\freecrm\\qa\\testdata\\ContactsTestData.xlsx";
	
	public static void moveToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName){
		
		try {
			fis = new FileInputStream(FILE_PATH);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet(sheetName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		int noofrows = ws.getLastRowNum();
		int noofcells = ws.getRow(0).getLastCellNum();
		Object[][] data = new Object[noofrows][noofcells];
		for(int i = 0 ; i <noofrows;i++){
			
			for(int j = 0 ; j<noofcells;j++){
				
				data[i][j] = ws.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		return data;
	}

}

package com.utils;

import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilites {
	public static final int implict_wait_time= 10;
	public static final int page_wait_time= 10; 
	public static String TimeStomp() {
		Date date = new Date();
		String timestomp =date.toString().replace("", "-").replace("", "_");
		return "anitha"+timestomp+"@gmail.com";
	}
public static void getTestDataFromExclsheet( String sheetName) {
	
	XSSFWorkbook workbook= new XSSFWorkbook();
	XSSFSheet sheet = workbook.getSheet(sheetName);
	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	for(int i= 0; i<rows;i++) {
		XSSFRow row = sheet.getRow(i+1);
		for(int j = 0;j<cols;j++) {
			XSSFCell cell= row.getCell(j);
		}
	}
	
	
	
	
	
	
	
}
	
}

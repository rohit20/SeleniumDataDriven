package com.amazon.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public static long page_load_timeout =20;
	public static long implicit_wait =10;
	public static String testdata_path= "/Users/rohitwadhwa/eclipse-workspace/AmazonTest/src/main/java/com/amazon/qa/testdata/RegistrationSheet.xlsx";
	 static Workbook book;
	 static Sheet sheet;



	public static Object[][] getTestdata(String sheetName){
		FileInputStream file= null;
		try {
			file= new FileInputStream(testdata_path);	
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			book= WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		for(int i =0; i<sheet.getLastRowNum();i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		
	
		return data;
	}

}

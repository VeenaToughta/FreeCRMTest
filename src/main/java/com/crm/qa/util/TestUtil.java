package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidObjectException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;

public class TestUtil {
	
	public static WebDriver driver;
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH="/users/veena_toughta/testdata.xls";
	static Workbook book;
	static Sheet sheet;
	
	
	//method used to get values from excel
	public static Object[][] getTestData(String SheetName)
	{
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		}catch(InvalidObjectException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(SheetName);
		Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
	//method to take screenshot when error occurs
	public static void takeScreenShotAtEndOfTest() throws IOException{
		System.out.println("TAKE SCREENSHOT");
		File scrFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("In loop 1........." +scrFile.getPath());
		String currentDir=System.getProperty("user.dir");
		
		System.out.println("current directory....." +currentDir);
		
		FileUtils.copyFile(scrFile, new File(currentDir +"/screenshots/" +System.currentTimeMillis() + ".png"));
		
	}
	


}

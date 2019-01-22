package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewTest4 {

	@Test
	public void testExcel() throws IOException
	{
		File file=new File("src/test/resources/Book1.xlsx");
		try {
			InputStream stream=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(stream);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			System.out.println("starting row count:" +sheet.getFirstRowNum());
			System.out.println("No of Rows" +sheet.getLastRowNum());
			System.out.println("No of active cells: " +sheet.getRow(0).getPhysicalNumberOfCells());
			
			Object[][] obj = new Object[sheet.getLastRowNum()][];

			
			
			for(int i=1;i<=sheet.getLastRowNum();i++ )
			{
				System.out.println("value is "+sheet.getRow(i).getCell(0).getStringCellValue());
				System.out.println("value1 is "+sheet.getRow(i).getCell(1).getStringCellValue());
				System.out.println("value2 is" +sheet.getRow(i).getCell(2).getStringCellValue());
			}
			
			workbook.close();
			stream.close();
		}
		finally {
			   //Statements to be executed
			}
	}
	
}

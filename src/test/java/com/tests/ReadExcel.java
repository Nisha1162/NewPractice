package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.Test;

	public class ReadExcel {

		@Test
		public static Object[][] readExcel() throws IOException
		{
			File file=new File("src/test/resources/Book2.xlsx");
			try {
				InputStream stream=new FileInputStream(file);
				XSSFWorkbook workbook=new XSSFWorkbook(stream);
				XSSFSheet sheet=workbook.getSheet("Sheet1");
				System.out.println("starting row count:" +sheet.getFirstRowNum());
				System.out.println("No of Rows" +sheet.getLastRowNum());
				System.out.println("No of active cells: " +sheet.getRow(0).getPhysicalNumberOfCells());
				
				Object[][] obj = new Object[sheet.getLastRowNum()][];
				
				for(int i=1;i<=sheet.getLastRowNum();i++)
				{
					obj[i-1]=new Object[2];
					
					for(int j=0;j<=sheet.getRow(i).getPhysicalNumberOfCells();)
					{
						obj[i-1][0]=sheet.getRow(i).getCell(j).getStringCellValue();
						}
				
				}
				return obj;
			}
			
			finally {
				   //Statements to be executed
				}
			
		}
		}

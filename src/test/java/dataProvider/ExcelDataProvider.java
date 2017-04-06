package dataProvider;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	// Constructor for the initialization 
	public ExcelDataProvider()
	{
		File src = new File("./AppTestData/AppData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	// Method to fetch the excel data using sheet index value
	
	public String getData(int sheetindex,int row,int col)
	{
		String data = wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	
	// Method to fetch the excel data using sheet name
	
	public String getData(String sheetname,int row,int col)
	{
		String data = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	

}

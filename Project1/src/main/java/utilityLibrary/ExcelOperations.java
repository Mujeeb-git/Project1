package utilityLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	String cellData;
	public String readExcel(String sheetName, int rowNum, int colNum) {
		try {
			// Specify the path of file
			File src = new File(System.getProperty("dir")+"\\DataSource\\Workbook1.xlsx");

			// load file
			FileInputStream fis = new FileInputStream(src);

			// Load workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Load sheet- Here we are loading first sheet only
			XSSFSheet sh1 = wb.getSheet(sheetName);

			// getRow() specify which row we want to read.

			// and getCell() specify which column to read.
			// getStringCellValue() specify that we are reading String data.
			cellData = sh1.getRow(rowNum).getCell(colNum).getStringCellValue();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return cellData;
		

	}

	public void writeExcel(String sheetName, int rowNum, int colNum) {
		
		try {
			 
			  // Specify the file path which you want to create or write
			 
			  File src=new File(System.getProperty("dir")+"\\DataSource\\Workbook1.xlsx");
			 
			  // Load the file
			 
			  FileInputStream fis=new FileInputStream(src);
			 
			   // load the workbook
			 
			   XSSFWorkbook wb=new XSSFWorkbook(fis);
			 
			  // get the sheet which you want to modify or create
			 
			   XSSFSheet sh1= wb.getSheet(sheetName);
			 
						 
			// here createCell will create column
			 
			// and setCellvalue will set the value
			 
			 sh1.getRow(rowNum).createCell(colNum).setCellValue("2.41.0");
			 
			 
			 
			 
			// here we need to specify where you want to save file
			 
			 FileOutputStream fout=new FileOutputStream(new File(System.getProperty("dir")+"\\DataSource\\Workbook2.xlsx"));
			 
			 
			// finally write content 
			 
			 wb.write(fout);
			 
			// close the file
			 
			 fout.close();
			 
			  } catch (Exception e) {
			 
			   System.out.println(e.getMessage());

	}
	}}

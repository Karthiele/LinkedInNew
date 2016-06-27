
/*Download the POI
 * I need add dependency in POM.xml. 
 * 1st dependency for POI
 * 2nd dependency for POI-OOXML
 * Create the Excel with 3 user name and Password. Stored the file under the project/data folder.
 * Create the New class excelData
 * Create the New method getdata() to retreive the values
 * Create the Object for Worksheet with insputstream. Since this is inputstream file, create a Inputstream for out data excel file. Pass this file as 
 * parameter for XSSFWorkbook object. 
 * Create the Worksheet object using the Workbook object workbook. 
 * Store the worksheet in worksheet object. 
 * Since i need to print all the user name, use for loop to iterate all the user name.
 * To iterate we need last row no, get it using getLastRowNo method.
 * 
 * 
 * */


package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Getdata 
{

	@Test
	public void getdata() throws IOException 
	{
		XSSFRow row;
		XSSFCell cell;
		int rowCount;
		int columnCount;
		FileInputStream fis = new FileInputStream("C:\\Users\\balajikumar\\Desktop\\Login.xlsx");		
		//FileInputStream fis = new FileInputStream("./data/Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
	
		rowCount = sheet.getLastRowNum();
		
		
		System.out.println(rowCount);
		
		for(int i = 1;i<=rowCount;i++)
		{
			row = sheet.getRow(i);
			cell = row.getCell(0);
			
			System.out.println("User Name is "+i+":"+cell.getStringCellValue());
			columnCount = row.getLastCellNum();
			
			for (int j = 0; j<columnCount;j++)
			{
				
			}
			
		}
		
	}
}

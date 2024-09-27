package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1: get the Excel path location & java Object of the physical ExcelFile
		FileInputStream  fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\testScript.xlsx");
		
		//Step 2: open WorkBook in read Mode
		Workbook wb=WorkbookFactory.create(fis);
		//Step 3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		//Step 4: get the control of the "1st" Row 
		Row row = sh.getRow(1);
		
		//Step 5: get the control of the "2nd" cell &read the String data 
	/*	Cell cel = row.getCell(2);
		String data = cel.getStringCellValue();   */
		double data=row.getCell(3).getNumericCellValue();
		System.out.println(data);
		//Step 6: close the WorkBook
		wb.close();
		
		

	}

}

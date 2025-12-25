package ExcelFileDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class DDExcelClass {
	@Test
	public void getDataFromExcel() throws IOException {
		ArrayList<String> ex = new ArrayList<String>();
		FileInputStream excelFile = new FileInputStream("C:\\Users\\DELL\\Downloads\\SeleniumExcelDD.xlsx");
		XSSFWorkbook excelData = new XSSFWorkbook(excelFile);
		int sheet = excelData.getNumberOfSheets();
		for (int i = 0; i < sheet; i++) {
			if (excelData.getSheetName(i).equalsIgnoreCase("LoginCred")) {

				XSSFSheet sheetName = excelData.getSheetAt(i);
				String sheetname = sheetName.getSheetName();
				// Sheet name
				System.out.println("Welcome:" + sheetname);
				
	//Data Retrival Start from Here...			
				// Row Iterate
				Iterator<Row> rows = sheetName.iterator();// It is the collection of rows

				while (rows.hasNext()) {

					Row r = rows.next();
					
		// Iterate threw first row column and check column name to fetch column details matches.
		
					Iterator<org.apache.poi.ss.usermodel.Cell> cel = r.cellIterator();
					while (cel.hasNext())
					{
						org.apache.poi.ss.usermodel.Cell celPre = cel.next();
						
						if (celPre.getStringCellValue().equalsIgnoreCase("Password"))
						{
							System.out.println("Match found:"+celPre.getStringCellValue());
						
						}
					}
				}
			}
		}

	}
}

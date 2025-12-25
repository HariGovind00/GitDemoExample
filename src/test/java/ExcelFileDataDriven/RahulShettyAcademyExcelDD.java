package ExcelFileDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class RahulShettyAcademyExcelDD 
{
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
			
				Iterator<Row> row=sheetName.rowIterator();
				//First Row ie:header as column names
				Row firstRow=row.next();
				Iterator<org.apache.poi.ss.usermodel.Cell> col=firstRow.cellIterator();
				int k=0;
				int column=0;
				while(col.hasNext())
				{
					org.apache.poi.ss.usermodel.Cell cel=col.next();
					System.out.println(cel.getStringCellValue());
					if(cel.getStringCellValue().equalsIgnoreCase("Password"))
					{
						column=k;
						//Iterating through password column
						while(row.hasNext())
						{
							Row colRow=row.next();
							System.out.println(colRow.getCell(column).getStringCellValue());
						}
						
					}
					k++;
				}
			}
		}
	}
}

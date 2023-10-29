package com.training.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel2 {
	public static void main(String[] args) throws IOException {
		
	FileInputStream file = new FileInputStream(new File("employee.xlsx"));

	// Create Workbook instance holding reference to .xlsx file
	XSSFWorkbook workbook = new XSSFWorkbook(file);

	// Get first/desired sheet from the workbook
	XSSFSheet sheet = workbook.getSheetAt(0);

	// Iterate through each rows one by one
	Iterator<Row> rowIterator = sheet.iterator();
	while(rowIterator.hasNext())
	{

		Row row = rowIterator.next();

		// For each row, iterate through all the columns
		Iterator<Cell> cellIterator = row.cellIterator();

		while (cellIterator.hasNext()) {

			Cell cell = cellIterator.next();

			switch (cell.getCellType()) {
			case STRING:
				System.out.print(cell.getStringCellValue() + "\t");
				break;
			case NUMERIC:
				System.out.print((cell.getNumericCellValue()) + "\t");
				break;
			}

		}
		System.out.println("");
	}file.close();

}
}

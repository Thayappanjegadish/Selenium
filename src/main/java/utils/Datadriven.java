package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Datadriven {

	public static void main (String[] args) throws IOException {


		FileInputStream obj = new FileInputStream("C:\\Users\\Seetharaman\\Documents\\python_Testdata.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(obj);

		int sheets = wb.getNumberOfSheets();

		for(int i = 0;i<sheets;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet  sheet = wb.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while(ce.hasNext()) {
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Bowlers")) {
						coloumn = k;
					}
					k++;
				}
				System.out.println(coloumn);

			}

		}

	}}

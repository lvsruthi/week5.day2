package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadIncidentExcel {

	public static String[][] readIncidentExcel(String Excelname) throws IOException {
	
		XSSFWorkbook wb = new XSSFWorkbook("./Excel/"+Excelname+".xlsx");
		XSSFSheet sh = wb.getSheet("Input");
		//get row count
		int row = sh.getLastRowNum();
		//getColumn count
		int column = sh.getRow(0).getLastCellNum();
		
		System.out.println(row + " " + column +"");
		String[][] Excel= new String[row][column];
		
		for(int i =1; i<=row;i++)
		{
			for(int j=0;j<column;j++)
			{
				
				Excel[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
				
				
			}
		}
		
		for(int i =0; i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				
				System.out.print(Excel[i][j]+  "  ");
						
			}
			System.out.println(" ");
		}
		return Excel;
		
		
		
		
		

	}

}

package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;

public class ReadExcel {

	
	public static String[][] readExcel(String name) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb = new XSSFWorkbook("./ExcelFile/"+name+ ".xlsx");
		
		XSSFSheet sh= wb.getSheet("Company");
		 int rowCount = sh.getLastRowNum(); //will eliminate the header
		 System.out.println("LAst row count is "+ rowCount);
		 int ColumnCount = sh.getRow(0).getLastCellNum();  //get the column count
		 System.out.println("Total column in headers is "+ ColumnCount);
		 String[][] Excel_Table = new String[rowCount][ColumnCount];
		 for (int i=1;i<=rowCount;i++)
		 {	XSSFRow row = sh.getRow(i);
			 for(int j=0;j<ColumnCount;j++)
			 {
				 XSSFCell cell = row.getCell(j);
				 String data = cell.getStringCellValue();
				 System.out.print(data + " ");
				 
				 Excel_Table[i-1][j]=data;
			 }
			 System.out.println("");
		 }
		 
		 return Excel_Table;
		
		
	}

}

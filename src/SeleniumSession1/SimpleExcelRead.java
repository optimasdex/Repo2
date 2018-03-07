package SeleniumSession1;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class SimpleExcelRead {
	String filePath = "Data.xlsx";
	int SheetID = 0;
	int colID = 4;
	
	@Test
	public void test() throws Exception {
		readdata(filePath, SheetID, colID);
	}
	
	public static void readdata(String filePath, int SheetID, int colID) throws Exception {
		
		//String filePath = "Data.xlsx";

		FileInputStream file = new FileInputStream(filePath);

		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheetAt(SheetID);
		
//		XSSFSheet ws = wb.getSheet(name);
		
		Iterator <Row> ri = ws.iterator();
		ri.next();
		
		//ArrayList<String> list = new ArrayList<String>();
		
		while(ri.hasNext()) {
			
			//System.out.println(ri.next().getCell(colID).getStringCellValue());
			
			//list.add(ri.next().getCell(1).getStringCellValue()); // getCell - column ID
		}
		wb.close();
	}
}

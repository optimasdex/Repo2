package SeleniumSession1;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data_Provider
{
	@DataProvider(name = "Excel_Dp1")
	public Object[][] testData() throws Exception
	{
		Object[][] data = ReadData("Data.xlsx");
		// System.out.println(data);
		return data;
	}
	
	public static String[][] ReadData(String filePath) throws Exception
	{
		//String filePath = "Data.xlsx";
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheetAt(0);

		int rc = ws.getLastRowNum() + 1;
		System.out.println("Total Rows - "+rc);
		int cc = ws.getRow(0).getLastCellNum();
		System.out.println("Total columns - "+cc);

		String[][] data = new String[rc][cc];

		for (int i = 0; i < rc; i++)
		{
			XSSFRow row = ws.getRow(i);
			
			for (int j = 0; j < cc; j++)
			{
				XSSFCell cell = row.getCell(j);
				//System.out.println(cell.CELL_TYPE_STRING);
				String val = cell.getStringCellValue();
				data[i][j] = val;
				//System.out.println(val);
			}
		}
		// System.out.println(data);
		wb.close();
		return data;
	}
}

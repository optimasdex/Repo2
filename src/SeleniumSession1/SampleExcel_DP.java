package SeleniumSession1;

import org.testng.annotations.Test;

public class SampleExcel_DP
{
	@Test(dataProvider="Excel_Dp1", dataProviderClass=SeleniumSession1.Data_Provider.class)
	public void testExcelDp(String a, String b, String c, String d, String e, String f)
	{
		
	}
}

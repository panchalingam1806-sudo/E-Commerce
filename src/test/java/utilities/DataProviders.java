package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException
	{
		String path =(".\\testData\\Login_data.xlsx");
		
		ExcelUtility utility = new ExcelUtility(path);
		
		int totalrows = utility.getRowCount("sheet1");
		int totalcols = utility.getCellCount("sheet1",1);
		
		String logindata[][] = new String [totalrows][totalcols];
		
		for(int r=1; r<=totalrows; r++)
		{
			for(int c=0;c<totalcols;c++)
			{
				logindata[r-1][c]=utility.getCellData("sheet1", r, c);
			}
		}
	return logindata;
	}
}
